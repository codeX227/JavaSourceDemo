package demos.jdktest;

public class StaticTest {

    public StaticTest() {
        System.out.println("默认构造方法！--");
    }

    //非静态代码块
    {
        System.out.println("非静态代码块！--");
    }
    //静态代码块
    static {
        System.out.println("静态代码块！--");
    }

    public static void test() {
        System.out.println("静态方法中的内容! --");
        {
            System.out.println("静态方法中的代码块！--");
        }

    }
    public static void main(String[] args) {

        StaticTest test = new StaticTest();
        StaticTest.test();//静态代码块！--静态方法中的内容! --静态方法中的代码块！--
    }
}
