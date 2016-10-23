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
    public void flatten(TreeNode root) {
        flattenTree(root);
    }

    private TreeNode flattenTree(TreeNode node) {
        if (node == null) return null;
        if (node.left == null && node.right == null) return node;
        if (node.left == null) return flattenTree(node.right);
        TreeNode left = flattenTree(node.left);
        left.right = node.right;
        node.right = node.left;
        node.left = null;
        return left.right != null ? flattenTree(left.right) : left;
    }
}
