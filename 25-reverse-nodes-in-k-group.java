/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode groupHead = dummy;
        ListNode tail = head;
        int count = 0;
        while (tail != null) {
            if (++count % k == 0) {
                tail = groupHead.next;
                for (int i = 1; i < k; i++) {
                    ListNode next = tail.next;
                    tail.next = next.next;
                    next.next = groupHead.next;
                    groupHead.next = next;
                }
                groupHead = tail;
                tail = groupHead.next;
            } else {
                tail = tail.next;
            }
        }
        return dummy.next;
    }
}
