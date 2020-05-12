package Thread.Product_Consumer.MoreProduct_MoreConsumer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yu
 */
public class Box {

    private static List list = new ArrayList();

    public synchronized void add() {
        if (size() < 50) {
            list.add("anyString");
            System.out.println("线程： " + Thread.currentThread().getName() + " 执行 add；Size为：" + size());
        }
    }

    public synchronized int size() {
        return list.size();
    }

    public synchronized Object popFirst() {
        Object value = list.remove(0);
        System.out.println("线程： " + Thread.currentThread().getName() + " 执行 pop；Size为：" + size());
        return value;
    }
}
