package solutions;

/**
 * @Description 二叉搜索树的第 k 大节点
 * @Author Goodenough
 * @Date 2021/2/11 19:15
 */
public class Offer54 {

    int count = 0, val;
    public int kthLargest(TreeNode root, int k) {

        dfs(root,k);
        return val;
    }
    public void dfs(TreeNode root, int k){
        if(root == null){
            return;
        }
        dfs(root.right, k);
        count++;
        if(count == k){
            val = root.val;
        }
        dfs(root.left,k);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
