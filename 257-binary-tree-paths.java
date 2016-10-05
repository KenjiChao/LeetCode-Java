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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root != null) traverse(root, "", res);
        return res;
    }

    private void traverse(TreeNode node, String path, List<String> res) {
        if (node.left == null && node.right == null) res.add(path + node.val);
        if (node.left != null) traverse(node.left, path + node.val + "->", res);
        if (node.right != null) traverse(node.right, path + node.val + "->", res);
    }
}
