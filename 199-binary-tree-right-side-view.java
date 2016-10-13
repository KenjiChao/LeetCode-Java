/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// recursive
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfsRight(root, res, 0);
        return res;
    }

    private void dfsRight(TreeNode node, List<Integer> res, int depth) {
        if (node == null) return;
        if (res.size() == depth) res.add(node.val);
        dfsRight(node.right, res, depth + 1);
        dfsRight(node.left, res, depth + 1);
    }
}

// iterative
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
                if (i == size - 1) res.add(node.val);
            }
        }
        return res;
    }
}
