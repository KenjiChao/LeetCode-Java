/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// Iterative, Time: O(n), Space: O(1)
public class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        while (fast != null) {
            if (fast.val != 9) slow = fast;
            fast = fast.next;
        }
        slow.val++;
        slow = slow.next;
        while (slow != null) {
            slow.val = 0;
            slow = slow.next;
        }
        return dummy.val == 0 ? dummy.next : dummy;
    }
}

// Recursive, Time: O(n), Space: O(n)
public class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode newHead = new ListNode(1);
        newHead.next = head;
        return addOne(head) == 0 ? head : newHead;
    }

    private int addOne(ListNode node) {
        if (node == null) return 1;
        int carry = addOne(node.next);
        if (carry == 0) return 0;
        carry += node.val;
        node.val = carry % 10;
        return carry / 10;
    }
}
