package com.jpa.test;

import JPA.SpringDataJpa.dao.RoleDao;
import JPA.SpringDataJpa.dao.UserDao;
import JPA.SpringDataJpa.pojo.Role;
import JPA.SpringDataJpa.pojo.User;
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
public class JpaManyToMany {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    /**
     * 多对多添加
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void testManyToManyAdd(){

        User user = new User();
        user.setUserName("u1");

        Role role = new Role();
        role.setRoleName("r1");

        //TODO 配置用户到角色的关系，可以对中间表中的数据进行维护   1-1
        user.getRoles().add(role);

        //TODO 配置角色到用户的关系，可以对中间表中的数据进行维护  1-1   两方都维护，则主键冲突。需要一方放弃维护权
        //TODO 多对多放弃维护权，被动的一方放弃维护权
        role.getUsers().add(user);

        userDao.save(user);
        roleDao.save(role);
    }

    /**
     * 多对多 级联添加
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void testCascadeManyToManyAdd(){

        User user = new User();
        user.setUserName("u1");

        Role role = new Role();
        role.setRoleName("r1");

        Role role1 = new Role();
        role1.setRoleName("rr1");

        //TODO 配置用户到角色的关系，可以对中间表中的数据进行维护   1-1
        user.getRoles().add(role);
        user.getRoles().add(role1);

        //TODO 配置角色到用户的关系，可以对中间表中的数据进行维护  1-1   两方都维护，则主键冲突。需要一方放弃维护权
        //TODO 多对多放弃维护权，被动的一方放弃维护权
        role.getUsers().add(user);
        role1.getUsers().add(user);

        userDao.save(user);
    }

    /**
     * 多对多 级联删除
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void testCascadeManyToManyDelete(){
        User one = userDao.findOne(1L);
        userDao.delete(one);
    }
}
