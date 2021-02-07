package algorithmn.list;

/**
 * @查找中间值问题
 * 单链表快慢指针
 * 当快指针指向最后一个节点时，慢指针指向中间节点
 */
public class FastSlowPointer {
    public static void main(String[] args) {
        //创建节点
        Node<String> first = new Node<>("aa", null);
        Node<String> second = new Node<>("bb", null);
        Node<String> third = new Node<>("cc", null);
        Node<String> fourth = new Node<>("dd", null);
        Node<String> fifth = new Node<>("ee", null);
        Node<String> sixth = new Node<>("ff", null);
        Node<String> seventh = new Node<>("gg", null);

        //连接 7 个节点
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;

        //查找中间值
        String mid = getMid(first);
        System.out.println("中间值为：" + mid);
    }

    /**
     *
     * @param first 链表首节点
     * @return 链表中间节点的值
     */
    public static String getMid(Node<String> first){
        //定义两个指针
        Node<String> low = first;
        Node<String> fast = first;
        //两指针遍历链表，当快指针指向节点的下一个节点为null，遍历结束，此时慢指针指向节点为中间值
        while (fast!=null && fast.next!=null){
            //快指针一次移两个，满指针一次移一个
            fast = fast.next.next;
            low = low.next;
        }
        return low.item;
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
