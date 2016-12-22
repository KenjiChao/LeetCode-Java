public class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int lo = 0, hi = n - 1;
        // find the smallest value using binaray search
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) lo = mid + 1;
            else hi = mid;
        }
        int rotation = lo;
        lo = 0;
        hi = n - 1;
        // binary search with index mapping
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int rotatedMid = (mid + rotation) % n;
            if (nums[rotatedMid] == target) return rotatedMid;
            else if (nums[rotatedMid] < target) lo = mid + 1;
            else hi = mid - 1;
        }

        return -1;
    }
}
