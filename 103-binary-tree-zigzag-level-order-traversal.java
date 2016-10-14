/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// BFS
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean goLeft = true;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (goLeft) list.add(node.val);
                else list.add(0, node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            res.add(list);
            goLeft = !goLeft;
        }
        return res;
    }
}

// DFS
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode node, List<List<Integer>> res, int level) {
        if (node == null) return;
        if (res.size() == level) {
            res.add(new ArrayList<Integer>());
        }
        List<Integer> list = res.get(level);
        if (level % 2 == 0) list.add(node.val);
        else list.add(0, node.val);
        dfs(node.left, res, level + 1);
        dfs(node.right, res, level + 1);
    }
}
