/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node , StringBuilder sb) {
        if (node == null) {
            sb.append("X,");
        } else {
            sb.append(node.val + ",");
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new ArrayDeque<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.removeFirst();
        if (val.equals("X")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

// BFS
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (sb.length() != 0) sb.append(",");
            sb.append(node == null ? "X" : node.val);
            if (node != null) {
                q.add(node.left);
                q.add(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = null;
        for (int i = 0; i < nodes.length; i++) {
            if (i == 0) {
                root = nodes[i].equals("X") ? null : new TreeNode(Integer.parseInt(nodes[i]));
                if (root != null) q.add(root);
            } else {
                TreeNode node = q.poll();
                TreeNode left = nodes[i].equals("X") ? null : new TreeNode(Integer.parseInt(nodes[i]));
                if (left != null) {
                    q.add(left);
                    node.left = left;
                }
                if (++i < nodes.length) {
                    TreeNode right = nodes[i].equals("X") ? null : new TreeNode(Integer.parseInt(nodes[i]));
                    if (right != null) {
                        q.add(right);
                        node.right = right;
                    }
                }
            }
        }
        return root;
    }
}
