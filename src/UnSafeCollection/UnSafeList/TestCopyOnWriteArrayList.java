package UnSafeCollection.UnSafeList;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestCopyOnWriteArrayList {
    public static void main(String[] args) {
        HelloThread ht = new HelloThread();
        for (int i = 0; i < 10; i++) {
            new Thread(ht).start();
        }
    }
}

/**
 * 使用迭代器
 * Collections.synchronizedList(new ArrayList<>());
 * 因为 迭代器 和 list 操作的同一个数据源 所以添加后会报错
 */
class HelloThread implements Runnable {

    //java.util.ConcurrentModificationException
    //private static List<String> list = Collections.synchronizedList(new ArrayList<>());

    private static List<String> list = new CopyOnWriteArrayList<>();

    static {
        list.add("AA");
        list.add("BB");
        list.add("CC");
    }

    @Override
    public void run() {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            //CopyOnWriteArrayList 添加时都会在底层复制一份新的列表
            list.add("AA");
            list.add("A");
        }
    }
}