public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0) return new int[0];
        int n = nums.length;
        int[] ret = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>(); // store index
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
            if (dq.peekFirst() == i - k) {
                dq.removeFirst();
            }
            if (i >= k - 1) ret[i - k + 1] = nums[dq.peekFirst()];
        }
        return ret;
    }
}
