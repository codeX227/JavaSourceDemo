package solutions;

/**
 * @Description 二叉树的深度
 * @Author Goodenough
 * @Date 2021/2/12 18:26
 */
public class Leetcode104 {

    int count = 0, max = 0;
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        count++;
        if(root.left==null && root.right==null){
            if(count > max)
                max = count;
        }

        maxDepth(root.left);
        maxDepth(root.right);
        count--;
        return max;
    }

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
  }
}
