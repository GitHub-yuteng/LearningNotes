package com.jpa.test;

import JPA.com.jpa.domain.Customer;
import JPA.com.jpa.util.JpaUtils;
import org.junit.Test;

import javax.persistence.*;
import java.util.List;

/**
 * @author Yu
 */
public class JpaTest {

    /**
     * 测试jpa的保存：persist
     * 案例:保存一个客户到数据库中
     * Jpa的操作步骤
     * 1.加载配置文件创建工厂(实体管理器工厂)对象 建过程比较浪费资源 它是线程安全的对象
     * 思路:创建一个公共的EntityManagerFactory的对象
     * 静态代码块的形式创建EntityManagerFactory
     * <p>
     * 2.通过实体管理器工厂获取实体管理器
     * EntityManagerFactory :获取EntityManager对象
     * 方法:createEntityManager
     * a.内部维护的很多的内容
     * b.内部维护了数据库信息，
     * c.维护了缓存信息
     * d.维护了所有的实体管理器对象
     * e.再创建EntityManagerFactory的过程中会根据配置创建数据库表
     * <p>
     * 3.获取事务对象，开启事务
     * 4.完成增删改查操作
     * 5.提交事务(回滚事务)
     * 6.释放资源
     */
    @Test
    public void testSave() {
        //TODO 加载配置文件创建工厂(实体管理器工厂)对象
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyJpa");
        //TODO 通过实体管理器工厂获取实体管理器
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //TODO 获取事务对象
        EntityTransaction transaction = entityManager.getTransaction();
        //TODO 开启事务
        transaction.begin();

        //TODO 保存一个客户到数据库中
        Customer customer = new Customer();
        customer.setCustName("余腾");
        customer.setCustIndustry("alibaba");
        customer.setCustLevel("99");
        //TODO 保存
        entityManager.persist(customer);
        //TODO 提交事务
        transaction.commit();
        //TODO 释放资源
        entityManager.close();
        //TODO 释放资源
        entityManagerFactory.close();
    }

    @Test
    public void testJpaUtilsSave() {
        //TODO 通过工具类获取 entityManager
        EntityManager entityManager = JpaUtils.getEntityManager();
        //TODO 获取事务对象
        EntityTransaction transaction = entityManager.getTransaction();
        //TODO 开启事务
        transaction.begin();

        //TODO 保存一个客户到数据库中
        Customer customer = new Customer();
        customer.setCustName("余腾");
        customer.setCustIndustry("alibaba");
        customer.setCustLevel("99");
        //TODO 保存
        entityManager.persist(customer);
        //TODO 提交事务
        transaction.commit();
        //TODO 释放资源
        entityManager.close();
    }

    /**
     * TODO 根据ID查询客户 Find  立即加载
     * 1、查询的对象就是当前客户对象本身
     * 2、在调用find方法的时候，就会发送sq1语句查询数据库
     */
    @Test
    public void testFindCustomer() {

        //TODO 通过工具类获取 entityManager
        EntityManager entityManager = JpaUtils.getEntityManager();
        //TODO 获取事务对象
        EntityTransaction transaction = entityManager.getTransaction();
        //TODO 开启事务
        transaction.begin();
        //TODO 查询
        Customer customer = entityManager.find(Customer.class, 1L);
        System.out.println(customer);
        //TODO 提交事务
        transaction.commit();
        //TODO 释放资源
        entityManager.close();
    }

    /**
     * TODO 根据ID查询客户 Reference  懒加载
     * getReference 方法
     * 1、获取的对象是一个动态代理对象
     * 2、调用 getReference 方法不会立即发送sql语句查询数据库
     * 3、什么时候用，什么时候查询
     */
    @Test
    public void testReferenceCustomer() {

        //TODO 通过工具类获取 entityManager
        EntityManager entityManager = JpaUtils.getEntityManager();
        //TODO 获取事务对象
        EntityTransaction transaction = entityManager.getTransaction();
        //TODO 开启事务
        transaction.begin();
        //TODO 查询
        Customer customer = entityManager.getReference(Customer.class, 1L);
        System.out.println(customer);
        //TODO 提交事务
        transaction.commit();
        //TODO 释放资源
        entityManager.close();
    }

    /**
     * TODO 删除客户 remove
     */
    @Test
    public void testRemoveCustomer() {

        //TODO 通过工具类获取 entityManager
        EntityManager entityManager = JpaUtils.getEntityManager();
        //TODO 获取事务对象
        EntityTransaction transaction = entityManager.getTransaction();
        //TODO 开启事务
        transaction.begin();
        //TODO 删除 （先查出来在删除）
        Customer customer = entityManager.find(Customer.class, 1L);
        //TODO delete from cst_customer where cust_id=?
        entityManager.remove(customer);
        //TODO 提交事务
        transaction.commit();
        //TODO 释放资源
        entityManager.close();
    }

    /**
     * TODO 更新客户 merge
     */
    @Test
    public void testUpdateCustomer() {

        //TODO 通过工具类获取 entityManager
        EntityManager entityManager = JpaUtils.getEntityManager();
        //TODO 获取事务对象
        EntityTransaction transaction = entityManager.getTransaction();
        //TODO 开启事务
        transaction.begin();
        //TODO 更新 （先查出来在更新）
        Customer customer = entityManager.find(Customer.class, 1L);
        customer.setCustPhone("188888888888");
        //TODO update cst_customer set cust_address=?, cust_industry=?, cust_level=?, cust_name=?, cust_phone=?, cust_source=? where cust_id=?
        Customer updateCustomer = entityManager.merge(customer);
        System.out.println(updateCustomer);
        //TODO 提交事务
        transaction.commit();
        //TODO 释放资源
        entityManager.close();
    }

    /**
     * TODO  JPQL 查询全部
     */
    @Test
    public void testJpqlFindAllCustomer() {

        //TODO 通过工具类获取 entityManager
        EntityManager entityManager = JpaUtils.getEntityManager();
        //TODO 获取事务对象
        EntityTransaction transaction = entityManager.getTransaction();
        //TODO 开启事务
        transaction.begin();
        //TODO 查询全部
//        String jpql = "FROM JPA.com.jpa.domain.Customer";
        String jpql = "FROM Customer";
        Query query = entityManager.createQuery(jpql);//TODO 创建Query查询对象，query对象才是执行jpql的对象

        //TODO 发送查询，并封装结果集
        List<Customer> list = query.getResultList();

        for (Customer customer : list) {
            System.out.println(customer);
        }
        //TODO 提交事务
        transaction.commit();
        //TODO 释放资源
        entityManager.close();
    }

    /**
     * TODO  JPQL 排序 查询全部 (默认 id 升序)
     * sql：SELECT * FROM `cst_customer` ORDER BY cust_id DESC
     * jpql：FROM Customer ORDER BY custId DESC
     */
    @Test
    public void testJpqlOrderFindAllCustomer() {

        //TODO 通过工具类获取 entityManager
        EntityManager entityManager = JpaUtils.getEntityManager();
        //TODO 获取事务对象
        EntityTransaction transaction = entityManager.getTransaction();
        //TODO 开启事务
        transaction.begin();
        //TODO 倒序查询全部
        String jpql = "FROM Customer ORDER BY custId DESC";
        Query query = entityManager.createQuery(jpql);//TODO 创建Query查询对象，query对象才是执行jpql的对象

        //TODO 发送查询，并封装结果集
        List<Customer> list = query.getResultList();

        for (Customer customer : list) {
            System.out.println(customer);
        }
        //TODO 提交事务
        transaction.commit();
        //TODO 释放资源
        entityManager.close();
    }

    /**
     * TODO  JPQL Count 统计
     * sql：SELECT COUNT(cust_id) FROM `cst_customer`
     * jpql：SELECT COUNT(custId) FROM Customer
     */
    @Test
    public void testJpqlCountCustomer() {

        //TODO 通过工具类获取 entityManager
        EntityManager entityManager = JpaUtils.getEntityManager();
        //TODO 获取事务对象
        EntityTransaction transaction = entityManager.getTransaction();
        //TODO 开启事务
        transaction.begin();
        //TODO 统计
        String jpql = "SELECT COUNT(custId) FROM Customer";
        Query query = entityManager.createQuery(jpql);//TODO 创建Query查询对象，query对象才是执行jpql的对象
        //TODO 得到唯一结果集
        //TODO Hibernate: select count(customer0_.cust_id) as col_0_0_ from cst_customer customer0_
        Object result = query.getSingleResult();
        System.out.println(result);

        //TODO 提交事务
        transaction.commit();
        //TODO 释放资源
        entityManager.close();
    }

    /**
     * TODO  JPQL Page 分页查询 要对 query 对象进行参数赋值
     * sql：SELECT * FROM `cst_customer` LIMIT ?,?
     * jpql：FROM Customer
     */
    @Test
    public void testJpqlPageCustomer() {

        //TODO 通过工具类获取 entityManager
        EntityManager entityManager = JpaUtils.getEntityManager();
        //TODO 获取事务对象
        EntityTransaction transaction = entityManager.getTransaction();
        //TODO 开启事务
        transaction.begin();
        //TODO 分页查询
        String jpql = "FROM Customer";
        Query query = entityManager.createQuery(jpql);//TODO 创建Query查询对象，query对象才是执行jpql的对象
        //TODO 对 query 进行参数赋值 -- 分页参数
        //TODO 起始索引
        query.setFirstResult(0);
        //TODO 每页查询的条数
        query.setMaxResults(1);

        List<Customer> list = query.getResultList();

        for (Customer customer : list) {
            System.out.println(customer);
        }

        //TODO 提交事务
        transaction.commit();
        //TODO 释放资源
        entityManager.close();
    }

    /**
     * TODO  JPQL 条件查询支持占位符 以 余 开头的对象
     * sql：SELECT * FROM `cst_customer` WHERE cust_name LIKE ?
     * jpql：FROM Customer WHERE custName LIKE ?
     */
    @Test
    public void testJpqlConditionCustomer() {

        //TODO 通过工具类获取 entityManager
        EntityManager entityManager = JpaUtils.getEntityManager();
        //TODO 获取事务对象
        EntityTransaction transaction = entityManager.getTransaction();
        //TODO 开启事务
        transaction.begin();
        //TODO 分页查询
        String jpql = "FROM Customer WHERE custName LIKE ?";
        Query query = entityManager.createQuery(jpql);//TODO 创建Query查询对象，query对象才是执行jpql的对象
        //TODO 对 query 进行参数复制 -- 占位符参数
        //TODO i 占位符索引 从 1 开始，o 查询条件
        query.setParameter(1, "余%");

        List<Customer> list = query.getResultList();

        for (Customer customer : list) {
            System.out.println(customer);
        }

        //TODO 提交事务
        transaction.commit();
        //TODO 释放资源
        entityManager.close();
    }
}
