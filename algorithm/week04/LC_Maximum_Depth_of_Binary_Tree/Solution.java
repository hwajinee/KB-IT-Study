package week04.LC_Maximum_Depth_of_Binary_Tree;

public class Solution {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2; node1.right = node3;
        node2.left = null; node2.right = null;
        node3.left = node4; node3.right = node5;
        node4.left = null; node4.right = null;
        node5.left = null; node5.right = null;

        Solution solution = new Solution();
        System.out.println(solution.maxDepth(node1));
    }

    static int maxDepth;

    public int maxDepth(TreeNode root) {
        maxDepth = 0;
        dfs(root, 1);
        return maxDepth;
    }

    public static void dfs(TreeNode root, int depth){
        if(root == null) return;

        if(depth > maxDepth) {
            maxDepth = depth;
        }

        dfs(root.left, depth+1);
        dfs(root.right, depth+1);

        return;
    }
}
