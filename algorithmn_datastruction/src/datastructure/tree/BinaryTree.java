package datastructure.tree;

import datastructure.queue.Queue;

/**
 * @二叉查找树
 */
public class BinaryTree<K extends Comparable, V> {

    //指向根节点的指针
    private Node root;
    //记录二叉树中元素个数
    private int N;

    public BinaryTree(){

    }

    /**
     * 获取二叉树元素个数
     */
    public int size(){
        return N;
    }

    /**
     * 向二叉树中插入一个节点
     */
    public void put(K key, V value){
        root = put(root, key, value);
    }

    /**
     * 向指定二叉树 x 中添加 key-value，并返回插入后的新二叉树
     */
    public Node put(Node x, K key, V value){
        //如果 x 子树为空，创建一个无子节点的新节点
        if (x == null){
            N++;
            return new Node(key, value, null,null);
        }
        //如果 x 子数不为空，
        int cmp = key.compareTo(x.key);
        if (cmp < 0){
            //key 小于于 x 节点的key，插入到 x 节点做子数
            x.left = put(x.left, key, value);
        }else if (cmp > 0){
            //key 大于 x 节点的key，插入到 x 节点右子数
            x.right = put(x.right, key, value);
        }else {
            //key 等于于 x 节点的key，覆盖 x 节点的 value
            x.value = value;
        }
        return x;
    }

    /**
     * 查询二叉树中指定 key 对应的 value
     */
    public V get(K key){
        return get(root, key);
    }

    /**
     * 查询指定二叉树 x 中指定 key 对应的 value
     */
    public V get(Node x, K key){

        if (x == null){
            return null;
        }
        //如果 x 子数不为空，
        int cmp = key.compareTo(x.key);
        if (cmp < 0){
            //key 小于于 x 节点的key，插入到 x 节点左子数
            return get(x.left, key);
        }else if (cmp > 0){
            //key 大于 x 节点的key，插入到 x 节点右子数
            return get(x.right, key);
        }else {
            //key 等于于 x 节点的key，返回对应 value
            return x.value;
        }
    }

    /**
     * 删除key-value
     */
    public void delete(K key){
        delete(root, key);
    }

    /**
     * 删除指定二叉树 x 中的key-value
     * @============================================待完成===================================================
     */
    private Node delete(Node x, K key){

//        if (x == null){
//            return null;
//        }
//        //如果 x 子数不为空，
//        int cmp = key.compareTo(x.key);
//        if (cmp < 0){
//            //key 小于于 x 节点的key，继续找 x 节点的左子节点
//            x.left = delete(x.left, key);
//        }else if (cmp > 0){
//            //key 大于 x 节点的key，继续找 x 节点的右子节点
//            x.right = delete(x.right, key);
//        }
//        //key 等于 x 节点的key，删除该节点
//        else {
//            //找到要删除的节点的右子树中最小的节点来替换要删除的节点
//            if (x.right==null && x.left!=null){
//                //如果右子树为空，左子树替换要删除节点
//                return x.left;
//            }
//            if (x.left==null && x.right!=null){
//                //如果左子树为空，右子树替换要删除的节点
//                return x.right;
//            }
//            //如果左右子树都不为空，找到右子树中最小节点
//            Node minNode = x.right;
//            Node pre = null;
//            while (minNode.left != null){
//                pre = minNode;
//                minNode = minNode.left;
//            }
//            pre.left = null;
//        }
        return null;
    }

    /**
     * 查找二叉查找树中最小键
     */
    public K min(){
        return min(root).key;
    }
    /**
     * 在指定树 x 中找到最小键所在节点
     */
    private Node min(Node x){
        if (x.left != null){
            return min(x.left);
        }else {
            return x;
        }
    }

    /**
     * 找出二叉查找树中最大键
     */
    public K max(){
        return max(root).key;
    }
    /**
     * 查找指定二叉查找树中最大键所在的节点
     */
    private Node max(Node x){
        if (x.right != null){
            return max(x.right);
        }else {
            return x;
        }
    }

    /**
     * 二叉查找树先序遍历
     */
    public Queue<K> preErgodic(){
        Queue<K> keys = new Queue<>();
        preErgodic(root, keys);
        return keys;
    }
    /**
     * 先序遍历指定树,保存到队列中
     */
    private void preErgodic(Node x, Queue<K> keys){
        if (x == null){
            return;
        }
        keys.enqueue(x.key);
        preErgodic(x.left, keys);
        preErgodic(x.right, keys);
    }

    /**
     * 二叉查找树中序遍历
     */
    public Queue<K> midErgodic(){
        Queue<K> keys = new Queue<>();
        midErgodic(root, keys);
        return keys;
    }
    /**
     * 中序遍历指定树,保存到队列中
     */
    private void midErgodic(Node x, Queue<K> keys){
        if (x == null){
            return;
        }
        midErgodic(x.left, keys);
        keys.enqueue(x.key);
        midErgodic(x.right, keys);
    }

    /**
     * 二叉查找树后序遍历
     */
    public Queue<K> afterErgodic(){
        Queue<K> keys = new Queue<>();
        afterErgodic(root, keys);
        return keys;
    }
    /**
     * 后序遍历指定树,保存到队列中
     */
    private void afterErgodic(Node x, Queue<K> keys){
        if (x == null)
            return;
        afterErgodic(x.left, keys);
        afterErgodic(x.right, keys);
        keys.enqueue(x.key);
    }

    /**
     * 二叉查找树层序遍历,保存到队列中
     */
    public Queue<K> layerErgodic(){
        //两个队列，分别存树中键和节点
        Queue<K> keys = new Queue<>();
        Queue<Node> nodes = new Queue<>();

        nodes.enqueue(root);
        while (!nodes.isEmpty()){
            //从 nodes 队列弹出一个节点，把节点的 key 存入队列 keys 中
            Node node = nodes.dequeue();
            keys.enqueue(node.key);
            //先左后右，子节点不为空就存入 nodes 队列
            if (node.left != null){
                nodes.enqueue(node.left);
            }
            if (node.right != null){
                nodes.enqueue(node.right);
            }
        }
        return keys;
    }
    /**
     * 获取整个二叉排序树最大深度
     */
    public int maxDepth(){
        return maxDepth(root);
    }
    /**
     * 获取指定树 x 最大深度
     */
    private int maxDepth(Node x){
        if (x == null){
            return 0;
        }
        // x 最大深度，左子树最大深度，右子树最大深度
        int max = 0;
        int maxL = 0;
        int maxR = 0;
        //计算左子树最大深度
        maxL = maxDepth(x.left);
        //计算右子树的最大深度
        maxR = maxDepth(x.right);
        //比较左右子树的最大深度
        max = maxL>maxR ? maxL+1 : maxR+1;

        return max;
    }


    /**
     * 节点类
     */
    private class Node{
        //键值对
        K key;
        V value;
        //左右子节点
        Node left;
        Node right;
        public Node(K key, V value, Node left, Node right){
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

    }
}
