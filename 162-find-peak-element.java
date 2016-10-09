public class Solution {
    public int findPeakElement(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int mid1 = mid + 1;
            if (nums[mid] > nums[mid1]) {
                hi = mid;
            } else {
                lo = mid1;
            }
        }
        return lo;
    }
}
