// O(n) guaranteed
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int start = lo;
            for (int i = lo; i < hi; i++) {
                if (nums[i] < nums[hi]) {
                    swap(nums, start++, i);
                }
            }
            swap(nums, start, hi);

            if (start < k) {
                lo = start + 1;
            } else if (start > k) {
                hi = start - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void shuffle(int[] nums) {
        final Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            swap(nums, i, random.nextInt(i + 1));
        }
    }
}
