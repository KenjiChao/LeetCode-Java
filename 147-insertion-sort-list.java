/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1);
        ListNode tail = head;
        while (tail != null) {
            ListNode pre = dummy;
            while (pre.next != null && pre.next.val < tail.val) {
                pre = pre.next;
            }
            ListNode next = tail.next;
            tail.next = pre.next;
            pre.next = tail;
            tail = next;
        }
        return dummy.next;
    }
}
