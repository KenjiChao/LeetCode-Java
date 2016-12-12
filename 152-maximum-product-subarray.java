public class Solution {
    public int maxProduct(int[] nums) {
        int positive = 1, negative = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int pos = positive, neg = negative;
            positive = Math.max(nums[i], Math.max(pos * nums[i], neg * nums[i]));
            negative = Math.min(nums[i], Math.min(pos * nums[i], neg * nums[i]));
            max = Math.max(max, positive);
        }
        return max;
    }
}
