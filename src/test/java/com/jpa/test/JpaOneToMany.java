package com.jpa.test;

import JPA.SpringDataJpa.dao.CustomerDao;
import JPA.SpringDataJpa.dao.LinkManDao;
import JPA.SpringDataJpa.pojo.Customer;
import JPA.SpringDataJpa.pojo.LinkMan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Yu
 */
@RunWith(SpringJUnit4ClassRunner.class)//TODO 声明spring提供的单元测试环境
@ContextConfiguration(locations = "classpath:applicationContext.xml")//TODO 指定Spring容器的配置信息
public class JpaOneToMany {

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private LinkManDao linkManDao;


    /**
     * 保存一个客户，保存该客户的联系人
     * 如果 One 方，放弃维护，则保存时，Many 方无外键赋值。
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void testAddOneToManyCustomerMaintain() {
        Customer customer = new Customer();
        customer.setCustName("c1");

        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("l1");

        LinkMan linkMan1 = new LinkMan();
        linkMan1.setLkmName("ll1");

        //TODO 建立关联关系  One 一方维护关系，会发送一条多余的 Update 语句。建议 One 方放弃维护关联关系
        customer.getLinkMans().add(linkMan);
        customer.getLinkMans().add(linkMan1);

        customerDao.save(customer);
        linkManDao.save(linkMan);
        linkManDao.save(linkMan1);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testAddOneToManyLinkManMaintain() {
        Customer customer = new Customer();
        customer.setCustName("c2");

        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("l2");

        LinkMan linkMan1 = new LinkMan();
        linkMan1.setLkmName("ll2");

        //TODO 建立关联关系    ==============> 推荐 Many 一方，维护关系。减少了sql的发送
        linkMan.setCustomer(customer);
        linkMan1.setCustomer(customer);

        customerDao.save(customer);
        linkManDao.save(linkMan);
        linkManDao.save(linkMan1);
    }

    /**
     * TODO 双向关联 。推荐 Many 一方，维护关系。减少了sql的发送。
     *      在 One 一方，放弃维护关联关系即可。
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void testAddOneToManyBothMaintain() {//TODO 双方都维护关系，如果用Lombok @Data 会报栈溢出
        Customer customer = new Customer();
        customer.setCustName("c3");

        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("l3");

        //TODO 建立双向关联关系    ==============> 推荐 Many 一方，维护关系。减少了sql的发送
        linkMan.setCustomer(customer);//TODO Many 一方维护关系时候，保存时，就已经对外键进行赋值保存
        customer.getLinkMans().add(linkMan);//TODO 因为配置了 One 一方维护关系，会发送 update 语句

        customerDao.save(customer);
        linkManDao.save(linkMan);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testCascadeAdd() {//TODO 双方都维护关系，如果用Lombok @Data 会报栈溢出
        //TODO 在操作主体的实体类上，配置 cascade 属性
        Customer customer = new Customer();
        customer.setCustName("c4");

        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("l4");

        LinkMan linkMan1 = new LinkMan();
        linkMan.setLkmName("ll4");

        //TODO 建立双向关联关系    ==============> 推荐 Many 一方，维护关系。减少了sql的发送
        linkMan.setCustomer(customer);//TODO Many 一方维护关系时候，保存时，就已经对外键进行赋值保存
        linkMan1.setCustomer(customer);
        customer.getLinkMans().add(linkMan);//TODO 因为配置了 One 一方维护关系，会发送 update 语句
        customer.getLinkMans().add(linkMan1);

        customerDao.save(customer);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testCascadeDelete() {//TODO 双方都维护关系，如果用Lombok @Data 会报栈溢出

        Customer one = customerDao.findOne(4L);
//        System.out.println(one);
        //TODO 不能 用对象 toString 方法。否则会造成栈溢出
        customerDao.delete(one);
    }
}
