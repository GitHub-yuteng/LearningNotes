package UnSafeCollection.UnSafeSet;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author Yu
 */
public class UnSafeHashSet {

    public static void main(String[] args) {

//        Set<String> set = new HashSet<>();
//        Set<String> set = Collections.synchronizedSet(new HashSet<>());
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set.toString());
            }, String.valueOf(i)).start();
        }
    }
}
