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

import java.util.Set;

/**
 * @author Yu
 */
@RunWith(SpringJUnit4ClassRunner.class)//TODO 声明spring提供的单元测试环境
@ContextConfiguration(locations = "classpath:applicationContext.xml")//TODO 指定Spring容器的配置信息
public class JpaObjectQuery {

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private LinkManDao linkManDao;

    /**
     * TODO 测试对象导航查询
     *  查询一个对象的时候，通过此对象查询所有的关联对象
     *  could not initialize proxy - no Session
     *
     * TODO 默认使用延迟加载的形式查询，用 findOne 也是延迟加载
     *  修改配置，变为 立即加载！
     *      fetch：需要配置到多表映射关系注解  fetch = FetchType.EAGER  默认-Lazy
     */
    @Test
    @Transactional//TODO 解决 no Session 错误
    public void testObjectQuery(){
        //TODO 查询id为1的客户
        Customer customer = customerDao.getOne(1L);
        //TODO 对象导航查询，此客户下的所有联系人
        Set<LinkMan> linkMans = customer.getLinkMans();

        for (LinkMan linkMan : linkMans) {
            System.out.println(linkMan);
        }
    }

    /**
     * 从多的一方 查询一的一方
     * 默认立即加载
     */
    @Test
    @Transactional//TODO 解决 no Session 错误
    public void testObjectQueryManyToFindOne(){
        LinkMan linkMan = linkManDao.findOne(2L);
        Customer customer = linkMan.getCustomer();
        System.out.println(customer);
    }
}
