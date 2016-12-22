public class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int lo = 0, hi = n - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) {
                // left half is sorted
                lo = mid + 1;
            } else if (nums[mid] < nums[hi]) {
                // right half is sorted
                hi = mid;
            } else hi--;
        }
        return nums[lo];
    }
}
