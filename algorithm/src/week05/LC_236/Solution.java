package week05.LC_236;

import java.util.Stack;

public class Solution {

    public static TreeNode lca_result;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> lca = new Stack<>();

        boolean first = false;
        // 트리 순회
        dfs(root, p, q, lca, first);
        return lca_result;
    }

    public static void dfs(TreeNode root, TreeNode p, TreeNode q, Stack<TreeNode> lca, boolean first){
        if(root.val == p.val){
            first = true;
        } else if(root.val == q.val){
            // 스택의 top에 있는 노드가 lca가 됨.
            lca_result = lca.peek();
            return;
        }

        if(first){ // 첫번째 노드 발견 후.
            // 첫 방문 시, push
            lca.push(root);
        } else { // 첫번째 노드 발견 전.
            // 첫 방문 시, (처리할 내용 없음)
        }

        // 첫 번째 노드 발견 여부와 관계없이
        // 다시 방문하는 노드는 스택에서 pop.
        if(lca.contains(root)) {
            lca.pop();
            return;
        }
        dfs(root.left, p, q, lca, first);
        dfs(root.right, p, q, lca, first);
    }
}