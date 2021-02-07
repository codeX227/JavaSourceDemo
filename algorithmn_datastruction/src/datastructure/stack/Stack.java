package datastructure.stack;

import java.util.Iterator;

/**
 * @自制栈
 */
public class Stack<T> implements Iterable {
    //首节点
    private Node head;
    //元素个数
    private int N;

    public Stack(){
        this.head = new Node(null,null);
        this.N = 0;
    }

    /**
     * 判断当前栈中元素个数是否为空
     */
    public boolean isEmpty(){
        return N == 0;
    }

    /**
     * 获取栈的元素个数
     */
    public int size(){
        return N;
    }

    /**
     * 把 t 压入栈
     */
    public void push(T t){
        //找到原来栈顶节点
        Node oldFirst = head.next;
        //创建新节点,将首节点指向新节点
        Node newNode = new Node(t, null);
        head.next = newNode;
        //新节点指向原来栈顶节点
        newNode.next = oldFirst;
        //元素个数+1
        N++;
    }

    /**
     * 弹出栈顶元素
     */
    public T pop(){
        //找到首节点指向的栈顶节点
        Node first = head.next;
        if (first == null){
            return null;
        }
        //将首节点指向原来栈顶节点的后一个节点
        head.next = first.next;
        //元素个数-1
        N--;
        return first.item;
    }

    /**
     * 节点类
     */
    private class Node {
        private T item;
        private Node next;
        public Node(T item, Node next){
            this.item = item;
            this.next = next;
        }
    }

    /**
     * 迭代器
     */
    @Override
    public Iterator iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator{

        private Node node;
        public SIterator(){
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
