package datastructure.queue;

public class QueueTest {

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();

        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");

        for (Object str : queue){
            System.out.print(str + " ");
        }

        System.out.println("\n------------------------------------");

        String result = queue.dequeue();
        System.out.println("弹出队列的元素是：" + result);
        System.out.println("弹出元素后队列的元素个数" + queue.size());
    }
}
