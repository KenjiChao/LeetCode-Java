// recursive
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
    public int closestValue(TreeNode root, double target) {
        TreeNode child = target < root.val ? root.left : root.right;
        if (child == null) return root.val;
        int val = closestValue(child, target);
        return Math.abs(root.val - target) < Math.abs(val - target) ? root.val : val;
    }
}

// iterative
public class Solution {
    public int closestValue(TreeNode root, double target) {
        int closest = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(closest - target)) closest = root.val;
            root = root.val < target ? root.right : root.left;
        }
        return closest;
    }
}
