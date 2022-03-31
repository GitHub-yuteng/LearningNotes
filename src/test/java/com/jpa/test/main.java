package com.jpa.test;

/**
 * @author whh-yt
 * @Date 2021/9/21
 * @Desc
 */
public class main {
    public static void main(String[] args) {
        for (int counter = 0; counter <= 20; counter++){
            System.out.printf("Fibonacci of %d is: %d\n", counter, fibonacci(counter));
        }
    }

    public static long fibonacci(long number) {
        if ((number == 0) || (number == 1))
            return number;
        else
            return fibonacci(number - 1) + fibonacci(number - 2);
    }
}
