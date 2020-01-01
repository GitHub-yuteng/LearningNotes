package Algorithm.Greedy;

import java.util.*;
import java.util.function.BiConsumer;

/**
 * @author Yu
 */
public class GreedyAlgorithm {

    public static void main(String[] args) {

        HashMap<String, HashSet<String>> broadCast = new HashMap<>();

        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        broadCast.put("k1", hashSet1);
        broadCast.put("k2", hashSet2);
        broadCast.put("k3", hashSet3);
        broadCast.put("k4", hashSet4);
        broadCast.put("k5", hashSet5);

        broadCast.forEach((k, v) -> System.out.println(k + "：" + v));

//        for (Map.Entry<String, HashSet<String>> entry : broadCast.entrySet()) {
//            System.out.println(entry.getKey()+"："+entry.getValue());
//        }


//        Iterator<Map.Entry<String, HashSet<String>>> iterator = broadCast.entrySet().iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }


        //TODO  allAreas 存放所有的地区
        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");

        //TODO 存放电台的集合
        List<String> selects = new ArrayList();

        //TODO 定义一个临时集合，遍历过程中，存放过程中的电台覆盖的地区和当前还没有覆盖的地区交集
        HashSet<String> tempSet = new HashSet<>();

        //TODO 定义一个 maxkey 保存在一次遍历过程中，能够覆盖最大未覆盖的地区对应电台的key
        String maxKey = null;
        //TODO 如果 maxkey 不为空，则加入到 selects;
        while (allAreas.size() != 0) {
            maxKey = null;
            for (String key : broadCast.keySet()) {
                //TODO 每次都要清空 tempSet
                tempSet.clear();
                HashSet<String> areas = broadCast.get(key);
                tempSet.addAll(areas);
                tempSet.retainAll(allAreas);

                //TODO 找到maxKey
                if (tempSet.size() > 0 &&
                        (maxKey == null || tempSet.size() > broadCast.get(maxKey).size())) {
                    maxKey = key;
                }
            }

            if (maxKey != null) {
                selects.add(maxKey);
                allAreas.removeAll(broadCast.get(maxKey));
            }
        }
        System.out.println("=========贪心=========");
        System.out.println(selects.toString());
    }
}
