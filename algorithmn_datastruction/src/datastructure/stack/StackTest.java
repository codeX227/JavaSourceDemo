package datastructure.stack;

public class StackTest {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        //测试压栈
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        for (Object item : stack){
            System.out.println(item);
        }
        System.out.println("====================================");

        //测试出栈
        String result = stack.pop();
        System.out.println("弹出元素是：" + result);
        System.out.println("剩余元素个数：" + stack.size());
    }
}
