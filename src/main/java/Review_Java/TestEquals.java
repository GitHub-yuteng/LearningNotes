package Review_Java;

import lombok.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 * @author Yu
 * <p>
 * String 中的 equals 方法是被重写过的
 * 因为 object 的 equals 方法是比较的对象的内存地址，而 String 的 equals 方法比较的是对象的值。
 * 当创建 String 类型的对象时，虚拟机会在常量池中查找有没有已经存在的值和要创建的值相同的对象，
 * 如果有就把它赋给当前引用。如果没有就在常量池中重新创建一个 String 对象。
 */
public class TestEquals {

    public static void main(String[] args) {

        String str1 = new String("ab"); //TODO  str1 为一个引用
        String str2 = new String("ab"); //TODO  str2 为另一个引用 与对象 str1 的内容一样

        String s1 = "ab"; //TODO 放在常量池中
        String s2 = "ab"; //TODO 从常量池中查找
        String s3 = "a" + "b";
        String s4 = "a" + new String("b");//TODO 后半部分无法在编译期确定

        System.out.println(str1 == str2);//TODO  false 不同对象，地址不相同
        System.out.println(s1 == s2);//TODO  true 同一对象引用，地址相同
        System.out.println(s1 == s3);//TODO  true
        System.out.println(s1 == s4);//TODO flase

        System.out.println(s1 == str2);//TODO  false
        System.out.println(s3 == str2);//TODO  false
        System.out.println(s4 == str2);//TODO  false


        System.out.println("======eq String内容相同都为true=======");
        System.out.println("s1.equals(s2) ：" + s1.equals(s2));//TODO true
        System.out.println("s1.equals(s3) ：" + s1.equals(s3));//TODO true
        System.out.println("s1.equals(s4) ：" + s1.equals(s4));//TODO true
        System.out.println("s3.equals(s4) ：" + s3.equals(s4));//TODO true
        System.out.println("str1.equals(str2) ：" + str1.equals(str2));//TODO true
        System.out.println("s1.equals(str1)：" + s1.equals(str1));//TODO true
        System.out.println("s4.equals(str1)：" + s4.equals(str1));//TODO true


        System.out.println("-------------------------------");

        String a = "a";
        String b = "bb";
        String strab = "abb";
        final String bb = "bb";//TODO 编译时被解析为常量值的一个本地拷贝存储到自己的常量  "a"+"bb" 等同于 "a" + bb

        String sab = a + b;//TODO 引用的值在编译期无法确定，运行时才可以动态分配赋值给 sab

        String saab = "a" + b;//TODO 引用的值在编译期无法确定
        String sbb = "a" + bb;

        System.out.println(strab == sab);//TODO false
        System.out.println(strab == saab);//TODO false
        System.out.println(strab == sbb);//TODO true

        System.out.println(saab == sbb);//TODO false

        System.out.println(strab.equals(sab));//TODO true
        System.out.println(strab.equals(saab));//TODO true


        System.out.println("==============================");

        String xyz = "x" + "y" + "z";
        String xyz1 = "xyz";
        System.out.println("xyz：" + (xyz == xyz1));//TODO true
        String x = "x";
        String y = "y";
        String z = "z";
        String strxyz = x + y + z;//TODO 相当于 StringBuffer
        System.out.println("strxyz：" + (xyz == strxyz));//TODO false

        StringBuffer temp = new StringBuffer();
        temp.append(x).append(y).append(z);
        String strtemp = temp.toString();

        System.out.println("=====StringBuffer Builder=====");

        String s = "a";
        StringBuffer sb = new StringBuffer(s);
        sb.append("b");
        String ab = sb.toString();
        System.out.println("StringBuffer：" + (s1 == ab));//TODO false
        System.out.println("StringBuffer：" + (s3 == ab));//TODO false
        System.out.println("StringBuffer：" + (str1 == ab));//TODO false

        String sa1 = "a";
        StringBuilder sb1 = new StringBuilder(sa1);
        sb1.append("b");
        String ab1 = sb1.toString();
        System.out.println("StringBuilder：" + (s1 == ab1));//TODO false
        System.out.println("StringBuilder：" + (s3 == ab1));//TODO false
        System.out.println("StringBuilder：" + (str1 == ab1));//TODO false


        System.out.println("==============================");

        System.out.println(1 == 1.0);//TODO true
        int i = 1;
        Integer integer = 1;
        System.out.println(i == integer);//TODO true
        System.out.println("i == Integer.parseInt(1) " + (i == Integer.parseInt("1")));//TODO true

        System.out.println("==============================");

        Map<User, Integer> map = new HashMap<>();

        User user = new User(1);
        User user1 = new User(1);

        System.out.println("== " + (user == user1));//TODO false
        System.out.println("eq " + (user.equals(user1)));//TODO 重写eq为true 不重写为 == false
        System.out.println("user hashcode " + (user.hashCode()));
        System.out.println("user1 hashcode " + (user1.hashCode()));

        map.put(user, 1);
        map.put(user1, 2);

        Iterator<Map.Entry<User, Integer>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<User, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class User {
    private int id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
