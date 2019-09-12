package com.jpa.test;

import JPA.SpringDataJpa.dao.CustomerDao;
import JPA.SpringDataJpa.pojo.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.List;

/**
 * TODO JpaSpecificationExecutor 方法列表
 * T findOne(Specification<T> spec);  //查询单个对象
 * List<T> findAll(Specification<T> spec);  //查询列表
 * Page<T> findAll(Specification<T> spec, Pageable pageable);  //分页查询全部
 * pageable：分页参数
 * Page(SpringData Jpa 提供)：PageBean
 * List<T> findAll(Specification<T> spec, Sort sort);  //排序查询列表
 * long count(Specification<T> spec);  //统计查询
 * <p>
 * TODO Specification
 * Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb);
 * root：查询的根对象(查询的任何属性都可以从根对象中获取)
 * CriteriaQuery：顶层查询对象，自定义查询方式(了解：一般不用)
 * CriteriaBuilder：查询的构造器，封装了很多的查询条件
 */
@RunWith(SpringJUnit4ClassRunner.class)//TODO 声明spring提供的单元测试环境
@ContextConfiguration(locations = "classpath:applicationContext.xml")//TODO 指定Spring容器的配置信息
public class SpecificationTest {

    @Autowired
    private CustomerDao customerDao;

    /**
     * TODO 条件查询
     */
    @Test
    public void SpecTest() {
        Specification<Customer> specification = (root, query, builder) -> {
            //TODO 获取比较的属性 （属性名称）
            Path<Object> custName = root.get("custName");
            //TODO 构造查询条件
            /**
             * 第一个参数:需要比较的属性(path对象)
             * 第二个参数:当前需要比较的取值
             */
            Predicate predicate = builder.equal(custName, "于腾");//TODO 进行精准匹配
            return predicate;
        };
        Customer one = customerDao.findOne(specification);
        System.out.println(one);
    }

    /**
     * TODO 多条件查询
     */
    @Test
    public void multiSpecTest() {
        Specification<Customer> specification = (root, query, builder) -> {
            //TODO 获取比较的属性
            Path<Object> custName = root.get("custName");
            Path<Object> custLevel = root.get("custLevel");
            //TODO 构造查询条件
            /**
             * 第一个参数:需要比较的属性(path对象)
             * 第二个参数:当前需要比较的取值
             */
            Predicate predicate1 = builder.equal(custName, "行简");
            Predicate predicate2 = builder.equal(custLevel, "2");

            Predicate predicate = builder.and(predicate1, predicate2);
            return predicate;
        };
        Customer one = customerDao.findOne(specification);
        System.out.println(one);
    }

    /**
     * TODO FindAllLike 多条件模糊查询
     */
    @Test
    public void multiSpecFindAllTest() {
        Specification<Customer> specification = (root, query, builder) -> {
            //TODO 获取比较的属性
            Path<Object> custName = root.get("custName");
            Path<Object> custLevel = root.get("custLevel");
            //TODO 构造查询条件
            /**
             * 第一个参数:需要比较的属性(path对象)
             * 第二个参数:当前需要比较的取值
             */
            //TODO 会报错。要得到path对象，根据path指定比较的参数类型，再去进行比较
            Predicate predicate1 = builder.like(custName.as(String.class), "行%");
            Predicate predicate2 = builder.equal(custLevel, "2");

            Predicate predicate = builder.and(predicate1, predicate2);
            return predicate;
        };

        List<Customer> list = customerDao.findAll(specification);
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }

    /**
     * TODO FindAllSort 多条件排序查询
     */
    @Test
    public void multiSpecFindAllSortTest() {
        Specification<Customer> specification = (root, query, builder) -> {
            //TODO 获取比较的属性
            Path<Object> custName = root.get("custName");
            Path<Object> custLevel = root.get("custLevel");
            //TODO 构造查询条件
            /**
             * 第一个参数:需要比较的属性(path对象)
             * 第二个参数:当前需要比较的取值
             */
            //TODO 会报错。要得到path对象，根据path指定比较的参数类型，再去进行比较
            Predicate predicate1 = builder.like(custName.as(String.class), "行%");
            Predicate predicate2 = builder.equal(custLevel, "2");

            Predicate predicate = builder.and(predicate1, predicate2);
            return predicate;
        };

        List<Customer> list = customerDao.findAll(specification, new Sort(Sort.Direction.DESC, "custId"));
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }

    /**
     * TODO 分页查询
     */
    @Test
    public void SpecPageTest() {
        Specification<Customer> specification = null;
        /**
         * 创建PageRequest的过程中，需要调用他的构造方法传入两个参数
         *  1、第一个参数：当前查询的页数(从0开始)
         *  2、第二个参数：每页查询的数量
         */
        Pageable pageable = new PageRequest(0, 2);//TODO Pageable接口的实现类
        Page<Customer> customerPage = customerDao.findAll(specification, pageable);
        System.out.println("当前页数据集合列表：");
        System.out.println(customerPage.getContent());
        System.out.println("总条数：" + customerPage.getTotalElements());
        System.out.println("总页数：" + customerPage.getTotalPages());
    }
}
