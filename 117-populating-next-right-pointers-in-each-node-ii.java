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
        if (root == null) return;
        TreeLinkNode head = root; // head of the next level
        TreeLinkNode cur = null; // current node of the current level
        while (head != null) {
            cur = head;
            head = null;
            TreeLinkNode child = null; // previous non-null node
            while (cur != null) {
                if (cur.left != null) {
                    if (child != null) child.next = cur.left;
                    else head = cur.left;
                    child = cur.left;
                }
                if (cur.right != null) {
                    if (child != null) child.next = cur.right;
                    else head = cur.right;
                    child = cur.right;
                }
                cur = cur.next;
            }
        }
    }
}
