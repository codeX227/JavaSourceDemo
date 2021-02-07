package datastructure.list;

import java.util.Iterator;

/**
 * @自制单链表
 */
public class LinkList<T> implements Iterable{
    //记录头节点
    private Node head;
    //记录链表长度
    private int N;
    //节点类
    private class Node{
        //存储数据
        T item;
        //下一个节点
        Node next;

        public Node(T item, Node next){
            this.item = item;
            this.next = next;
        }
    }

    //构造头节点
    public LinkList(){
        //初始化头节点
        this.head = new Node(null, null);
        //初始化元素个数
        this.N = 0;
    }

    //清空链表
    public void clear(){
        head.next = null;
        this.N = 0;
    }

    //获取链表长度
    public int length(){
        return N;
    }

    //断链表是否为空
    public boolean isEmpty(){
        return N == 0;
    }

    //获取指定位置 i 处的元素
    public T get(int i){
        //循环从头节点找 i 次
        Node node = head.next;
        for (int index=0; index<i; index++){
            node = node.next;
        }
        return node.item;
    }

    //添加元素 t
    public void insert(T t){
        //找到最后一个节点
        Node node = head;
        while (node.next != null){
            node = node.next;
        }
        //创建新节点，并指向新节点
        node.next = new Node(t, null);
        //元素个数 +1
        N++;
    }

    //向指定位置 i 处添加元素 t
    public void insert(int i, T t){
        //找到第 i 个节点的前一个节点
        Node pre = head;
        for (int index=0; index<i; index++){
            pre = pre.next;
        }
        //找到第 i 个节点
        Node curr = pre.next;
        //创建新节点，指向原来第 i 个节点
        Node newNode = new Node(t, curr);
        //连接
        pre.next = newNode;
        //元素个数+1
        N++;
    }

    //删除指定位置 i 处元素，并返回删除元素
    public T remove(int i){
        //找到第 i 个节点的前一个节点
        Node pre = head;
        for (int index=0; index<i; i++){
            pre = pre.next;
        }
        //找到第 i 个节点
        Node curr = pre.next;
        //找到第 i 个节点的下一个节点
        Node nextNode = curr.next;
        //第 i 个节点的上一个节点指向下一个节点
        pre.next = nextNode;
        //元素个数 -1
        N--;
        return curr.item;
    }

    //查找元素 t 第一次出现的位置
    public int indexOf(T t){
        //从头节点开始依次比较 item 的值
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
     * 反转整个单链表
     */
    public void reverse(){
        //链表为空直接返回
        if (this.isEmpty()){
            return;
        }
        reverse(head.next);
    }
    private Node reverse(Node node){
        if (node.next == null){
            head.next = node;
            return node;
        }
        //递归反转 node 节点的下一个节点，pre 为反转前的右节点，node为反转前左节点
        Node pre = reverse(node.next);
        pre.next = node;
        node.next = null;
        return node;
    }

    /**
     * 迭代器
     * @return iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new LIterator();
    }
    private class LIterator implements Iterator{
        private Node node;

        public LIterator(){
            this.node = head;
        }

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
