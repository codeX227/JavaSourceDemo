package solutions;

/**
 * @Description 是否平衡二叉树
 * @Author Goodenough
 * @Date 2021/2/12 19:07
 */
public class Leetcode110 {

    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;

        return Math.abs(maxDep(root.left)-maxDep(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxDep(TreeNode root){
        if(root==null)
            return 0;
        return Math.max(maxDep(root.left), maxDep(root.right)) + 1;
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
