package algorithmn.list;

/**
 * @测试单链表是否有环问题
 * 快慢指针相遇代表单链表有环
 */
public class CircleListCheckTest {
    public static void main(String[] args) {
        //创建节点
        //连接 7 个节点
        Node<String> first = new Node<>("aa", null);
        Node<String> second = new Node<>("bb", null);
        Node<String> third = new Node<>("cc", null);
        Node<String> fourth = new Node<>("dd", null);
        Node<String> fifth = new Node<>("ee", null);
        Node<String> sixth = new Node<>("ff", null);
        Node<String> seventh = new Node<>("gg", null);
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;

        //产生一个环
        seventh.next = third;

        //判断是否有环
        boolean circle = isCircle(first);
        System.out.println("是否有环：" + circle);
    }

    /**
     * 判断链表是否有环
     * @param first 链表头节点
     * @return true为有环，false为无环
     */
    public static boolean isCircle(Node<String> first){
        //定义两个指针
        Node<String> low = first;
        Node<String> fast = first;
        //如果两个指针指向同一个节点，说明有环
        //没有环就会结束循环
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            low = low.next;
            if (fast.equals(low)){
                return true;
            }
        }
        return false;
    }

    /**
     * 节点类
     * @param <T>
     */
    private static class Node<T>{
        private T item;
        private Node next;
        public Node(T item, Node next){
            this.item = item;
            this.next = next;
        }
    }
}
