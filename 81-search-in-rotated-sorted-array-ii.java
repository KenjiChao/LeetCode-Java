public class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return true;
            if (nums[lo] < nums[mid]) {
                // left half is sorted
                if (nums[lo] <= target && target < nums[mid]) hi = mid - 1;
                else lo = mid + 1;
            } else if (nums[lo] > nums[mid]) {
                // right half is sorted
                if (nums[mid] < target && target <= nums[hi]) lo = mid + 1;
                else hi = mid - 1;
            } else {
                lo++;
            }
        }
        return false;
    }
}
