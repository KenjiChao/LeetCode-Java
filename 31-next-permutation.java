public class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                reverse(nums, i + 1, n - 1);
                int index = searchLargerIndex(nums, i + 1, n - 1, nums[i]);
                swap(nums, i, index);
                break;
            } else if (i == 0) {
                reverse(nums, 0, n - 1);
            }
        }
    }

    private int searchLargerIndex(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    private void reverse(int[] nums, int start, int end) {
        for (;start < end; start++, end--) {
            swap(nums, start, end);
        }
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}
