/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) slow = slow.next;
        slow = reverse(slow);
        return isEqual(head, slow);
    }

    private boolean isEqual(ListNode n1, ListNode n2) {
        if (n1 == null || n2 == null) return true;
        if (n1.val != n2.val) return false;
        return isEqual(n1.next, n2.next);
    }

    private ListNode reverse(ListNode node) {
        ListNode newHead = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = newHead;
            newHead = node;
            node = next;
        }
        return newHead;
    }
}
