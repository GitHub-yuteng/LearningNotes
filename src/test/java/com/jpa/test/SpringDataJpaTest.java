package com.jpa.test;

import JPA.SpringDataJpa.dao.CustomerDao;
import JPA.SpringDataJpa.pojo.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)//TODO 声明spring提供的单元测试环境
@ContextConfiguration(locations = "classpath:applicationContext.xml")//TODO 指定Spring容器的配置信息
public class SpringDataJpaTest {

    @Autowired
    private CustomerDao customerDao;

    /**
     * TODO findOne 立即查询
     */
    @Test
    public void testFindOne() {
        Customer one = customerDao.findOne(1L);
        System.out.println(one);
    }

    /**
     * TODO getOne 延迟加载
     *
     * @Transactional：保证getOne正常运行
     */
    @Test
    @Transactional
    public void testGetOne() {
        Customer one = customerDao.getOne(1L);
        System.out.println(one);
    }

    /**
     * TODO save：保存或者更新
     * 根据传递的对象是否存在主键id,
     * 如果没有id主键属性：保存
     * 存在id主键属性，根据id查询数据，更新数据
     */
    @Test
    public void testSave() {
        Customer customer = new Customer();
        customer.setCustName("行筠");
        customer.setCustPhone("11111111111");
        Customer save = customerDao.save(customer);
        System.out.println(save);
    }

    /**
     * TODO save：保存或者更新
     * 存在id主键属性，根据id查询数据，更新数据
     * 如果创建新对象，进行更新，会置空数据库其他字段。（需要先查出要更新的对象，在进行字段更新）
     */
    @Test
    public void testUpdate() {
        Customer customer = new Customer();
        customer.setCustId(1L);
        customer.setCustName("行筠");
        customer.setCustPhone("11111111111");
        Customer save = customerDao.save(customer);
        System.out.println(save);
    }

    /**
     * TODO delete：删除
     */
    @Test
    public void testDelete() {
        //TODO  delete from cst_customer where cust_id=?
        customerDao.delete(6l);
    }

    /**
     * TODO 查询所有
     */
    @Test
    public void testFindAll() {
        List<Customer> list = customerDao.findAll();
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }

    /**
     * TODO 统计查询
     */
    @Test
    public void testCount() {
        //TODO select count(*) as col_0_0_ from cst_customer customer0_
        long count = customerDao.count();//TODO 查看总条数
        System.out.println(count);
    }

    /**
     * TODO 判断是否存在
     */
    @Test
    public void testExists() {
        boolean exists = customerDao.exists(1L);
        System.out.println(exists);
    }
}
