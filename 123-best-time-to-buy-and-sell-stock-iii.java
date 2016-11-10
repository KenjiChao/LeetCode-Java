public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;
        int[] dp = new int[n];
        int profit = 0;
        for (int k = 0; k < 2; k++) {
            int curMax = dp[0] - prices[0];
            for (int i = 1; i < n; i++) {
                int val = Math.max(dp[i - 1], prices[i] + curMax);
                curMax = Math.max(curMax, dp[i] - prices[i]);
                dp[i] = val;
                profit = Math.max(profit, val);
            }
        }
        return profit;
    }
}
