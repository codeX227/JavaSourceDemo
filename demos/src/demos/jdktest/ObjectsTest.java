package demos.jdktest;

import java.util.Objects;

public class ObjectsTest {
    public static void main(String[] args) {
        String str1 = null;
        boolean flag = Objects.equals("str", str1);
        System.out.println(null=="aaa");
        System.out.println("Str".equals(str1));
        System.out.println(flag);
        System.out.println(String.valueOf("str4"));
    }
}
