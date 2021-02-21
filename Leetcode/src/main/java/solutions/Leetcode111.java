package solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 二叉树最小深度 BFS
 * @Author Goodenough
 * @Date 2021/2/21 19:52
 */
public class Leetcode111 {

    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int minDep = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode curr = queue.poll();
                if(curr.left==null && curr.right==null){
                    return minDep;
                }
                if(curr.left != null)
                    queue.offer(curr.left);
                if(curr.right != null)
                    queue.offer(curr.right);
            }
            minDep++;
        }
        return minDep;
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
