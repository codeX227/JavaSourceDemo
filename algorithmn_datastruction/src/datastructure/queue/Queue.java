package datastructure.queue;

import java.util.Collection;
import java.util.Iterator;

/**
 * @自制队列
 */
public class Queue<T> implements Iterable {
    //记录首节点的指针
    private Node head;
    //记录尾节点的指针
    private Node last;
    //记录队列元素个数
    private int N;

    public Queue(){
        this.head = new Node(null, null);
        this.last = null;
        this.N = 0;
    }

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty(){
        return N == 0;
    }

    /**
     * 返回队列元素个数
     */
    public int size() {
        return N;
    }

    /**
     * 向队列插入元素
     */
    public void enqueue(T t){
        //如果尾指针为null说明没有元素，头指针和尾指针直接指向插入的新节点
        if (last == null){
            last = new Node(t, null);
            head.next = last;
        }else {
            //尾指针不为null，原来尾节点指向新节点，尾指针指向新节点
            last.next = new Node(t,null);
            last = last.next;
        }
        //元素个数+1
        N++;
    }

    /**
     * 从队列拿出一个元素
     */
    public T dequeue(){
        //队列为空，返回null
        if (isEmpty()){
            return null;
        }
        Node oldFirst = head.next;
        head.next = oldFirst.next;
        N--;
        //当队列元素删除完，重置尾指针为null
        if (isEmpty()){
            last = null;
        }
        return oldFirst.item;
    }

    /**
     * 内部节点类
     */
    private class Node{
        T item;
        Node next;
        public Node(T item, Node next){
            this.item = item;
            this.next = next;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new QIterator();
    }
    private class QIterator implements Iterator {
        Node node;

        public QIterator(){
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
