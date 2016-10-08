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
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, 0, root.val);
    }

    private int dfs(TreeNode root, int len, int target) {
        if (root == null) return 0;
        len = root.val == target ? len + 1 : 1;
        int left = dfs(root.left, len, root.val + 1);
        int right = dfs(root.right, len, root.val + 1);
        return Math.max(len, Math.max(left, right));
    }
}
