/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Best solution without modifying tree
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.addFirst(cur);
                cur = cur.left;
            }
            cur = stack.removeFirst();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}

// Modify the tree structure
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addFirst(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peekFirst();
            if (node.left != null) {
                stack.addFirst(node.left);
                node.left = null;
            } else {
                stack.removeFirst();
                if (node.right != null) stack.addFirst(node.right);
                res.add(node.val);
            }
        }
        return res;
    }
}
