/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;
        int left = depth(node.left);
        if (left == -1) return -1;
        int right = depth(node.right);
        if (right == -1 || Math.abs(left - right) > 1) return -1;
        return 1 + Math.max(left, right);
    }
}
