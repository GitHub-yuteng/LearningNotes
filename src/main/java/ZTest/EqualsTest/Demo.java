package ZTest.EqualsTest;

import java.util.*;

public class Demo {

    public static void main(String[] args) {

        /**
         * 重写了 hashcode() 两个对象的 hashcode 才相等。
         */
        People p1 = new People("Jack", 12);
        System.out.println(p1.hashCode());//71329710

        People p2 = new People("Jack", 12);
        System.out.println(p2.hashCode());//71329710

        HashMap<People, Integer> hashMap = new HashMap<>();
        hashMap.put(p1, 1);

        //TODO 在设计hashCode方法和equals方法的时候，如果对象中的数据易变
        //TODO 则最好在equals方法和hashCode方法中不要依赖于该字段。

        // p1.setAge(1);//如果更改了字段值，hashcode值将更改
        // System.out.println(p1.hashCode());//71329699

        System.out.println(hashMap.get(p1));//
        System.out.println(hashMap.get(p2));//如果不重写 则为 null

        /**
         * equals 如果不重写底层为  == 比较的为 对象地址 则为 false
         * public boolean equals(Object obj) {
         *      return (this == obj);
         * }
         */
        System.out.println(p1.equals(p2));// 期望值为 true

        System.out.println("----------------");

        int i1 = 12;
        int i2 = 12;
        System.out.println(i1 == i2);//true

        String s1 = "hello";
        String s2 = "hello";
        System.out.println(s1 == s2);//true

        String str = new String("hello");
        String str1 = new String("hello");
        String str2 = new String("hello");
        System.out.println("->:" + (str1 == str2));// ->:false
        System.out.println("=>:" + str1.equals(str2));// =>:true

        str1 = str;
        str2 = str;
        System.out.println("->:" + (str1 == str2));// ->:true


        System.out.println("----------------");

        Integer i3 = 127;
        Integer i4 = 127;
        //It's best to use equals() to compare
        System.out.println(i3 == i4);//TODO true
        System.out.println(i3.equals(i4));//TODO true

        Integer i5 = 128;
        Integer i6 = 128;
        //It's best to use equals() to compare
        System.out.println(i5 == i6);//TODO falsed
        System.out.println(i5.equals(i6));//TODO true

        System.out.println("----------------");


        HashMap<String, String> map = new HashMap();
        map.put("1", "2");
        map.put("2", "3");
        map.put("3", "3");
        map.put(null, "3");
        map.put(null, null);
        map.put("4", null);


        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + "=>" + value);
        }

        System.out.println("==========");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "->" + value);
        }

        System.out.println("==========");

        HashSet<String> set = new HashSet<>();
        set.add("1");
        set.add("1");
        set.add("2");
        set.add(null);

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }
        /**
         * null
         * 1
         * 2
         */

    }
}

class People {

    private String name;
    private int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        People people = (People) o;
//        return age == people.age &&
//                Objects.equals(name, people.name);
//    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}