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

// use only one binary search
public class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return mid;
            if (nums[hi] < nums[mid]) {
                // left half is sorted
                if (nums[lo] <= target && target < nums[mid]) hi = mid - 1;
                else lo = mid + 1;
            } else {
                // right half is sorted
                if (nums[mid] < target && target <= nums[hi]) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return -1;
    }
}
