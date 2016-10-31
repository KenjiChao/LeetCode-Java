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
    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (count == k - 1) return root.val;
        else if (count >= k) return kthSmallest(root.left, k);
        else return kthSmallest(root.right, k - count - 1);
    }

    private int countNodes(TreeNode node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
}

// inorder
public class Solution {
    int count;
    int val;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return val;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        count--;
        if (count == 0) {
            val = node.val;
            return;
        }
        dfs(node.right);
    }
}
