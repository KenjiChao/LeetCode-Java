public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int n = nums.length;
        int first = binarySearchFirst(nums, target, 0, n);
        if (first == n || nums[first] != target) return res;
        res[0] = first;
        res[1] = binarySearchFirst(nums, target + 1, first, n) - 1;
        return res;
    }

    private int binarySearchFirst(int[] nums, int target, int start, int end) {
        int lo = start;
        int hi = end;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
