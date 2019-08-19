package DesignPatterns.StructuralType.Proxy.StaticProxy;

/**
 * @author Yu
 */
//静态代理
public class TeacherDaoProxy implements ITeacherDao {

    private TeacherDao target;

    //构造器
    public TeacherDaoProxy(TeacherDao target) {
        this.target = target;
    }

    @Override
    public void teach() {
        System.out.println("代理对象...开始！---> 提前完成一些事情！");
        target.teach();
        System.out.println("代理对象...结束！---> 提交");
    }
}
