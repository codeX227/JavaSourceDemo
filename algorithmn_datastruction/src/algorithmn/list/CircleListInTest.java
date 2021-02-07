package algorithmn.list;

/**
 * @查找有环单链表的环的入口问题
 * 临时指针在快慢指针相遇后开始移动，
 * 临时指针和快慢指针相遇时所指向的节点即为环入口
 */
public class CircleListInTest {
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
        Node<String> entrance = getEntrance(first);
        System.out.println("链表中环的入口节点的值为：" + entrance.item);
    }

    /**
     * 查找有环链表中环的入口节点
     * @param first 首节点
     * @return 环的入口节点
     */
    public static Node<String> getEntrance(Node<String> first){
        //定义快慢指针和临时指针
        Node<String> low = first;
        Node<String> fast = first;
        Node<String> temp = null;
        //1.判断是否有环，找到环时临时指针开始移动，且移动步长和慢指针相同
        //2.临时指针和慢指针相遇的节点为环入口节点
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            low = low.next;
            //快慢指针相遇时，临时指针从下一次循环开始移动
            if (fast.equals(low)){
                temp = first;
                continue;
            }
            //移动临时指针，临时指针和慢指针相遇时结束循环，temp指向节点为环入口
            if (temp != null){
                temp = temp.next;
                if (temp.equals(low)){
                    break;
                }
            }
        }
        return temp;
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
