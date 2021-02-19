package ZTest;

import lombok.Data;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        User user = new User();
        user.setI(1);
        user.setJava("111");
        System.out.println(Stream.of(user).collect(Collectors.toList()));

        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);

    }
    public static int getValue(int i) {
        int result = 0;
        switch (i) {
            case 1:
                result = result + i;
            case 2:
                result = result + i * 2;
            case 3:
                result = result + i * 3;
        }
        return result;
    }
}

@Data
class User{
    private int i;
    private String java;


}