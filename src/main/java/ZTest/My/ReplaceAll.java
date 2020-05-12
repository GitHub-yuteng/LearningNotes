package ZTest.My;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ReplaceAll {

    static int a;
    int aa;

    public static void main(String[] args) {
        String classFile = "com.jd.". replaceAll(".", "/") + "MyClass.class";
        System.out.println(classFile);

    }
}
