package UnSafeCollection.UnSafeList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * @author Yu
 */
public class UnSafeList {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
//        List<String> list = Collections.synchronizedList(new ArrayList<>());
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list.toString());
            }, String.valueOf(i)).start();
        }
    }
}