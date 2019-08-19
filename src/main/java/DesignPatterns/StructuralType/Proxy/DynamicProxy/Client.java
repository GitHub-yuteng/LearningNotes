package DesignPatterns.StructuralType.Proxy.DynamicProxy;


/**
 * @author Yu
 */
public class Client {
    public static void main(String[] args) {

        //创建目标，被代理对象
        TeacherDao target = new TeacherDao();

        //给目标对象创建代理对象
        //返回用接口接收，因为只有接口才能保证代理对象和目标对象方法一致
        ITeacherDao proxyInstance = (ITeacherDao) new ProxyFactory(target).getProxyInstance();

        //class com.sun.proxy.$Proxy0 内存中生成的代理对象
        System.out.println(proxyInstance.getClass());
        proxyInstance.teach();
        System.out.println("=====================");
        String str = proxyInstance.write("余腾");
        System.out.println(str);
    }
}
