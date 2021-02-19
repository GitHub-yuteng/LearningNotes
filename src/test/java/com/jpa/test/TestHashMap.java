package com.jpa.test;

import lombok.Data;
import org.junit.Test;

import java.util.HashMap;

/**
 * @Author: yuteng
 * @Package: com.jpa.test
 * @Description:
 * @Date: Created in 9:11 2020/12/11
 */
public class TestHashMap {


    @Test
    public void map() {

        People people = new People();
        people.setAge(1);

        HashMap<String, People> hashMap = new HashMap();
        hashMap.put("1", people);


        People people1 = hashMap.get("1");
        System.out.println(people1);
        people.setAge(2);
        System.out.println(people1);
        People people2 = hashMap.get("1");
        System.out.println(people2);

    }

}

@Data
class People {

    int age;

}