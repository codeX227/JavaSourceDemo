package datastructure.tree;

import datastructure.queue.Queue;

/**
 * 二叉排序树遍历测试
 */
public class BinaryTreeErgodicTest {
    public static void main(String[] args) {

        BinaryTree<String, String> tree = new BinaryTree<>();

        tree.put("E","5");
        tree.put("B","2");
        tree.put("G","7");
        tree.put("A","1");
        tree.put("D","4");
        tree.put("F","6");
        tree.put("H","8");
        tree.put("C","3");
//        //先序遍历
//        Queue<String> queue = tree.preErgodic();
//        for (Object key : queue){
//            String value = tree.get((String) key);
//            System.out.println(key + "----" + value);
//        }
//        //中序遍历
//        Queue<String> queue = tree.midErgodic();
//        for (Object key : queue){
//            String value = tree.get((String) key);
//            System.out.println(key + "----" + value);
//        }
//        //后序遍历
//        Queue<String> queue = tree.afterErgodic();
//        for (Object key : queue){
//            String value = tree.get((String) key);
//            System.out.println(key + "----" + value);
//        }
        //层序遍历
        Queue<String> queue = tree.layerErgodic();
        for (Object key : queue){
            String value = tree.get((String) key);
            System.out.println(key + "----" + value);
        }
    }
}
