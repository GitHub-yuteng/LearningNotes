package DesignPatterns.Proxy.CGLibProxy;


/**
 * @author Yu
 */
public class Client {
    public static void main(String[] args) {

        //创建目标，被代理对象
        TeacherDao target = new TeacherDao();

        //创建代理对象，将目标对象传递给代理对象
        TeacherDao proxyInstance = (TeacherDao) new ProxyFactory(target).getProxyInstance();

        System.out.println(proxyInstance.getClass());
        proxyInstance.teach();
        System.out.println("=====================");
        String str = proxyInstance.write("余腾");
        System.out.println(str);
    }
}
