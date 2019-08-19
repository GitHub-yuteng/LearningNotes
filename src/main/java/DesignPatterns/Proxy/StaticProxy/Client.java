package DesignPatterns.Proxy.StaticProxy;

/**
 * @author Yu
 */
public class Client {

    public static void main(String[] args) {

        //创建目标，被代理对象
        TeacherDao teacherDao = new TeacherDao();

        //创建 代理对象，同时把被代理对象传给代理对象
        TeacherDaoProxy teacherDaoProxy = new TeacherDaoProxy(teacherDao);

        //通过代理对象的方法，调用被代理对象的方法
        teacherDaoProxy.teach();
    }
}
