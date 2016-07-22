public class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, maxSofar = 0;
        for (int i = 0; i < nums.length; i++) {
            maxSofar = Math.max(maxSofar + nums[i], nums[i]);
            max = Math.max(max, maxSofar);
        }

        return max;
    }
}
