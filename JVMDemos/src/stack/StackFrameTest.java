package stack;

/**
 * 方法结束方式分为两种
 * 1.正常结束，以return为代表
 * 2.方法执行中出现未处理异常，以抛出异常方式结束
 */
public class StackFrameTest {

    public static void main(String[] args) {

        try {
            StackFrameTest test = new StackFrameTest();
            test.method1();
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("main()正常结束");
    }

    public void method1() {
        System.out.println("method1()开始执行");
        int m = method2();
        System.out.println(10 / 0);
        System.out.println("method1执行结束");
    }

    public int method2() {
        System.out.println("method2开始执行");
        int i = 10;
        int m = (int) method3();
        System.out.println("method2即将结束");
        return (i + m);
    }

    public double method3(){
        System.out.println("method3开始执行");
        double j = 20.0;
        System.out.println("method3即将结束");
        return j;
    }
}
