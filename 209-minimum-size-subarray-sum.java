public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int i = 0, j = 0, min = Integer.MAX_VALUE, sum = 0;
        while (j < n) {
            sum += nums[j++];
            while (i < j && sum >= s) {
                min = Math.min(min, j - i);
                sum -= nums[i++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
