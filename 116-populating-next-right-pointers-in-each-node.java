/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null || root.left == null) return;
        TreeLinkNode cur = root;
        while (cur != null) {
            cur.left.next = cur.right;
            if (cur.next != null) cur.right.next = cur.next.left;
            cur = cur.next;
        }
        connect(root.left);
    }
}

public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode level = root;
        TreeLinkNode cur = null;
        while (level.left != null) {
            cur = level;
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null) cur.right.next = cur.next.left;
                cur = cur.next;
            }
            level = level.left;
        }
    }
}
