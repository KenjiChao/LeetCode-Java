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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> ret = new ArrayList<>();
        Stack<Integer> stack1 = new Stack<>(); // stores values <= target
        Stack<Integer> stack2 = new Stack<>(); // stores values > target
        inorder(root, target, stack1, false);
        inorder(root, target, stack2, true);
        while (k-- > 0) {
            if (stack1.isEmpty()) ret.add(stack2.pop());
            else if (stack2.isEmpty()) ret.add(stack1.pop());
            else if (target - stack1.peek() < stack2.peek() - target) ret.add(stack1.pop());
            else ret.add(stack2.pop());
        }
        return ret;
    }

    private void inorder(TreeNode node, double target, Stack<Integer> stack, boolean reverse) {
        if (node == null) return;
        inorder(reverse ? node.right : node.left, target, stack, reverse);
        if ((!reverse && node.val > target) || (reverse && node.val <= target)) return;
        stack.add(node.val);
        inorder(reverse ? node.left : node.right, target, stack, reverse);
    }
}
