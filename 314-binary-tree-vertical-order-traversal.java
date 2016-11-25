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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        int[] range = {0, 0};
        getRange(root, range, 0);
        for (int i = range[0]; i <= range[1]; i++) {
            res.add(new ArrayList<>());
        }

        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> colQ = new LinkedList<>();
        q.add(root);
        colQ.add(-range[0]);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            int col = colQ.poll();
            res.get(col).add(node.val);
            if (node.left != null) {
                q.add(node.left);
                colQ.add(col - 1);
            }
            if (node.right != null) {
                q.add(node.right);
                colQ.add(col + 1);
            }
        }
        return res;
    }

    private void getRange(TreeNode node, int[] range, int col) {
        if (node == null) return;
        range[0] = Math.min(range[0], col);
        range[1] = Math.max(range[1], col);
        getRange(node.left, range, col - 1);
        getRange(node.right, range, col + 1);
    }
}
