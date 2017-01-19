// top down
public class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] nums_bound = new int[n];
        int[][] memo = new int[n][n];
        nums_bound[0] = 1;
        nums_bound[n - 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            nums_bound[i + 1] = nums[i];
        }
        return burst(memo, nums_bound, 0, n - 1);
    }

    private int burst(int[][] memo, int[] nums, int left, int right) {
        if (left + 1 == right) return 0;
        if (memo[left][right] > 0) return memo[left][right];
        int ret = 0;
        for (int i = left + 1; i < right; i ++) {
            ret = Math.max(ret, burst(memo, nums, left, i) + nums[left] * nums[i] * nums[right] + burst(memo, nums, i, right));
        }
        memo[left][right] = ret;
        return ret;
    }
}

// bottom up dp
public class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] nums_bound = new int[n];
        int[][] dp = new int[n][n];
        nums_bound[0] = nums_bound[n - 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            nums_bound[i + 1] = nums[i];
        }

        for (int k = 2; k < n; k++) {
            for (int left = 0; left + k < n; left++) {
                int right = left + k;
                for (int i = left + 1; i < right; i++) {
                    dp[left][right] = Math.max(dp[left][right], nums_bound[i] * nums_bound[left] * nums_bound[right] +  dp[left][i] + dp[i][right]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
