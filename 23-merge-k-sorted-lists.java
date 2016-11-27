/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(n, new Comparator<ListNode>() {
            @Override
            public int compare (ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        });
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        for (int i = 0; i < n; i++) {
            if (lists[i] != null) pq.add(lists[i]);
        }
        while (!pq.isEmpty()) {
            tail.next = pq.poll();
            tail = tail.next;
            if (tail.next != null) pq.add(tail.next);
        }
        return head.next;
    }
}
