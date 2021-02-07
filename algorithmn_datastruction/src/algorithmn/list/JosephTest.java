package algorithmn.list;

/**
 * @约瑟夫问题
 * 1.构建循环链表，包含41个节点，分别存储1~41之间的值
 * 2.count计数器模拟报数
 * 3.遍历循环链表,遇到count = 3时重置count=0，删除该节点，当节点指向自己时说明只剩一个结点
 */
public class JosephTest {

    public static void main(String[] args) {
        //1.构建循环链表，包含41个节点，分别存储1~41之间的值
        //指向首节点的指针
        Node<Integer> first = null;
        //指向前一个节点的指针
        Node<Integer> pre = null;

        for (int i=1; i<=41; i++){
            //如果是第一个节点，首指针和pre指针指向第一个节点
            if (i == 1){
                first = new Node<>(i, null);
                pre = first;
            }
            //中间节点
            else if (i>1 && i<41){
                Node<Integer> newNode = new Node<>(i, null);
                pre.next = newNode;
                pre = pre.next;
            }
            //最后一个节点
            else if (i == 41){
                Node<Integer> newNode = new Node<>(i, null);
                pre.next = newNode;
                newNode.next = first;
            }
        }
        //2.count计数器模拟报数
        int count = 0;
        //3.遍历循环链表
        //记录每次拿到的节点，默认从首节点开始
        Node<Integer> node = first;
        //记录当前节点的上一个节点
        Node<Integer> before = null;
        //只剩最后一个节点时，该节点指向自己
        while (node != node.next){
            //模拟报数
            count++;

            if (count == 3){
                //报数为 3 时，打印并删除该节点，重置count=0重新报数，当前节点后移
                count =0;
                System.out.print(node.item + ",");
                before.next = node.next;
                node = node.next;
            }else {
                //报数不为 3，将before指向当前节点，当前节点后移
                before = node;
                node = node.next;
            }
        }
        //打印最后一个元素的值
        System.out.println(node.item);
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
