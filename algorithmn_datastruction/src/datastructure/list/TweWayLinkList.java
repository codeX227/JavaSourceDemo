package datastructure.list;

import java.util.Iterator;

/**
 * @自制LinkList双向链表
 */
public class TweWayLinkList<T> implements Iterable{
    //指向头节点
    private Node head;
    //指向尾节点
    private Node last;
    //链表长度
    private int N;
    //构造方法初始化头尾节点和元素个数
    public TweWayLinkList(){
        this.head = new Node(null,null,null);
        this.last = null;
        this.N = 0;
    }

    //节点类
    private class Node{
        T item;
        Node pre;
        Node next;
        public Node(T t, Node pre, Node next){
            this.item = t;
            this.pre = pre;
            this.next = next;
        }
    }

    /**
     * 清空链表
     */
    public void clear(){
        this.head.next = null;
        this.last = null;
        this.N = 0;
    }
    /**
     * 获取链表长度
     */
    public int length(){
        return N;
    }
    /**
     * 判断链表是否为空
     */
    public boolean isEmpty(){
        return N == 0;
    }
    /**
     * 获取第一个元素
     */
    public T getFirst(){
        if (isEmpty()){
            return null;
        }
        return head.next.item;
    }
    /**
     * 获取最后一个元素
     */
    public T getLast(){
        if (this.isEmpty()){
            return null;
        }
        return last.item;
    }
    /**
     * 尾部插入元素
     */
    public void insert(T t){
        if (this.isEmpty()){
            //链表为空，将新创建节点作为尾节点
            Node newNode = new Node(t, head, null);
            last = newNode;
            head.next = last;
        }else {
            //链表不为空，在尾节点后插入新节点,新节点作为尾节点
            Node oldNode = last;
            Node newNode = new Node(t, oldNode, null);
            oldNode.next = newNode;
            last = newNode;
        }
        //元素个数 +1
        N++;
    }
    /**
     * 向指定位置处插入元素
     */
    public void insert(int i, T t){
        //找到 i 处节点的前一个节点
        Node pre = head;
        for (int index=0; index<i; index++){
            pre = pre.next;
        }
        //找到 i 处节点
        Node curr = pre.next;
        //创建新节点，将新节点分别指向 i 处前一个节点和原 i 处节点
        Node newNode = new Node(t, pre, curr);
        //将原 i 处节点前节点指向新节点，原 i 处节点指向新节点
        curr.pre = newNode;
        pre.next = newNode;
        //元素个数 +1
        N++;
    }
    /**
     * 获取 i 处元素
     */
    public T get(int i){
        Node node = head.next;
        for (int index=0; index<i; index++){
            node = node.next;
        }
        return node.item;
    }
    /**
     * 获取元素 t 第一次出现位置
     */
    public int indexOf(T t){
        Node node = head;
        for (int i=0; node.next!=null; i++){
            node = node.next;
            if (node.item.equals(t)){
                return i;
            }
        }
        return -1;
    }
    /**
     * 删除 i 处元素
     */
    public T remove(int i){
        //找到 i 处节点的前节点
        Node pre = head;
        for (int index=0; index<i; index++) {
            pre = pre.next;
        }
        //找到 i 处节点
        Node curr = pre.next;
        //找到 i 处节点的后节点
        Node nextNode = curr.next;
        // i处节点的左右节点相互连接
        pre.next = nextNode;
        nextNode.pre = pre;
        //元素个数 -1
        N--;
        return curr.item;
    }
    @Override
    public Iterator iterator() {
        return new TIterator();
    }
    private class TIterator implements Iterator{

        private Node node = head;

        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public Object next() {
            node = node.next;
            return node.item;
        }
    }
}
