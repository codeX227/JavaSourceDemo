package datastructure.symbol;

/**
 * @有序符号表，键值对存储元素的单向链表
 * @头插法插入元素
 */
public class OrderSymbolTable<K extends Comparable<K>, V> {
    //首节点指针
    private Node head;
    //元素个数
    private int N;

    public OrderSymbolTable(){
        //初始首节点
        this.head = new Node(null,null,null);
        //初始化元素个数
        N = 0;
    }

    /**
     * 获取表中键值对个数
     */
    public int size(){
        return N;
    }

    /**
     * 插入一个键值对
     */
    public void put(K key, V value){
        //定义两个指针，分别指向当前节点和当前节点的上一个节点
        Node pre = head;
        Node node = head.next;
        //要插入节点的 key 大于当前节点的 key，移动两个指针
        while (node!=null && key.compareTo(node.key)>0){
            pre = node;
            node = node.next;
        }
        //如果表中已存在键为 key 的键值对，覆盖原来键的 key 的键值对的 value
        if (key.equals(node.key)){
            node.value = value;
            return;
        }
        //不存在键为 key 的键值对，把新节点插入到当前节点 node 之前
        pre.next = new Node(key, value,node);
        N++;
    }

    /**
     * 删除表中键为 key 的键值对
     */
    public void delete(K key){
        Node node = head;
        while (node.next != null){
            //记录当前节点前一个节点的指针
            Node pre = node;
            node = node.next;
            if (node.key.equals(key)){
                pre.next = node.next;
                N--;
                return;
            }
        }
    }

    /**
     * 获取表中键为 key 的键值对的值
     */
    public V get(K key){
        Node node = head;
        while (node.next != null){
            node = node.next;
            if (node.key.equals(key)){
                return node.value;
            }
        }
        return null;
    }

    private class Node{
        K key;
        V value;
        Node next;
        public Node(K key, V value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
