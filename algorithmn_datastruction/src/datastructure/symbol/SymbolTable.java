package datastructure.symbol;

/**
 * @符号表，键值对存储元素的单向链表
 * @头插法插入元素
 */
public class SymbolTable<K, V> {
    //首节点指针
    private Node head;
    //元素个数
    private int N;

    public SymbolTable(){
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
        //如果表中已存在键为 key 的键值对，覆盖原来键的 key 的键值对的 value
        Node node = head;
        while (node.next != null){
            node = node.next;
            if (node.key.equals(key)){
                node.value = value;
                return;
            }
        }
        //不存在键为 key 的键值对，头插法插入该键值对
        Node newNode = new Node(key, value, head.next);
        head.next = newNode;
        //元素个数+1
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
