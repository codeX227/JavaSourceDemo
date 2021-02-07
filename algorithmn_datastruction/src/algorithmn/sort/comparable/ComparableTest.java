package algorithmn.sort.comparable;

/**
 * 定义测试类，定义测试方法Comparable getMax(Comparable c1, Comparable c2)完成测试
 */
public class ComparableTest {

    public static void main(String[] args) {
        Student student1  = new Student();
        student1.setAge(18);
        student1.setUsername("张三");

        Student student2 = new Student();
        student2.setUsername("李四");
        student2.setAge(20);

        Comparable max = getMax(student1, student2);
        System.out.println(max);
    }

    public static Comparable getMax(Comparable c1, Comparable c2){
        //result > 0,则c1比c2大
        //result = 0,则相等
        //result < 0,则c1比c2小
        int result = c1.compareTo(c2);
        if (result >= 0){
            return c1;
        }else {
            return c2;
        }

    }
}
