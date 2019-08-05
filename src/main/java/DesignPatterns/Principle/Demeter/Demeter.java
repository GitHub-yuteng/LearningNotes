package DesignPatterns.Principle.Demeter;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yu
 * //TODO 迪米特原则 要求降低耦合，而不是完全解耦
 * <p>
 * 1、一个对象应该对其他对象保持最少的了解
 * 2、类与类关系越密切，耦合度越大
 * 3、迪米特法则(Demeter Principle)又叫最少知道原则，即一一个类对自己依赖的类知道的
 * 越少越好。也就是说，对于被依赖的类不管多么复杂，都尽量将逻辑封装在类的内部。
 * 对外除了提供的public方法，不对外泄露任何信息。
 * <p>
 * 4、迪米特法则还有个更简单的定义:只与直接的朋友通信
 * 5、直接的朋友:每个对象都会与其他对象有耦合关系，只要两个对象之间有耦合关系，
 * 我们就说这两个对象之间是朋友关系。耦合的方式很多，依赖，关联，组合，聚合
 * 等。其中，我们称出现成员变量，方法参数，方法返回值中的类为直接的朋友，而
 * 出现在局部变量中的类不是直接的朋友。也就是说，陌生的类最好不要以局部变量
 * 的形式出现在类的内部。
 * <p>
 * //TODO 直接朋友
 *      class A{
 *          B b;
 *          public B m1(){}
 *          public void m2(B b){}
 *          public void m3(){
 *              B b1 = new B();// 局部变量 非直接朋友
 *          }
 *       }
 */
public class Demeter {
    public static void main(String[] args) {
        SchoolManager schoolManager = new SchoolManager();
        schoolManager.printAllEmployee(new CollegeManager());
    }
}

//学院员工类
class CollegeEmployee {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

//管理学院员工的管理类:
class CollegeManager {
    //返回学院的所有员工 //TODO CollegeEmployee 直接朋友
    public List<CollegeEmployee> getAllEmployee() {
        List<CollegeEmployee> list = new ArrayList<CollegeEmployee>();
        for (int i = 0; i < 10; i++) { //这里我们增加了10 个员工到list ，
            CollegeEmployee emp = new CollegeEmployee();
            emp.setId("学院员工id " + i);
            list.add(emp);
        }
        return list;
    }

    public void printCollegeEmployee() {
        List<CollegeEmployee> list1 = this.getAllEmployee();
        System.out.println("---学院员工----");
        for (CollegeEmployee e : list1) {
            System.out.println(e.getId());
        }
    }
}

//学校总部员工类
class SchoolEmployee {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

//学校管理类
//TODO 直接朋友 Employee CollegeManager
class SchoolManager {
    //返回学校总部的员工
    public List<SchoolEmployee> getAllEmployee() {
        List<SchoolEmployee> list = new ArrayList<SchoolEmployee>();
        for (int i = 0; i < 5; i++) { //这里我们增加了5个员工到list
            SchoolEmployee emp = new SchoolEmployee();
            emp.setId("学校总部员工id= " + i);
            list.add(emp);
        }
        return list;
    }

    //该方法完成输出学校总部和学院员工信息(id)
    void printAllEmployee(CollegeManager sub) {
        //获取到学院员工
        //TODO 非直接朋友 CollegeEmployee  应该提取到  CollegeManager
//        List<CollegeEmployee> list1 = sub.getAllEmployee();
//        System.out.println("---学院员工----");
//        for (CollegeEmployee e : list1) {
//            System.out.println(e.getId());
//        }
        sub.printCollegeEmployee();//只提供方法，不把具体实现放在其他类里面。

        //获取到学校总部员工
        List<SchoolEmployee> list2 = this.getAllEmployee();
        System.out.println("------学校总部员工------");
        for (SchoolEmployee e : list2) {
            System.out.println(e.getId());
        }
    }
}
