public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum < S || (S + sum) % 2 > 0) return 0;
        return subsetSum(nums, (S + sum) / 2);
    }

    private int subsetSum(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = target; i >= num; i--) dp[i] += dp[i - num];
        }
        return dp[target];
    }
}
