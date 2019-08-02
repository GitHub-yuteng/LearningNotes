package JVM.OOM.OutOfMemoryError;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Yu
 * -XX:MetaspaceSize=50m -XX:MaxMetaspaceSize=50m
 */
public class Metaspace {

    static class OOM {}

    public static void main(final String[] args) {

        int count = 0;
        try {
            while (true) {
                count++;
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OOM.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(o, args);
                    }
                });
                enhancer.create();
            }
        } catch (Throwable e) {
            System.out.println("count 次后发生异常: " + count);
            e.printStackTrace();
        }
    }
}
