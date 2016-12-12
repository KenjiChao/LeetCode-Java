public class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[] dp = new int[3];
        for (int i = 0; i < n; i++) {
            int costRed = dp[0], costBlue = dp[1], costGreen = dp[2];
            dp[0] = costs[i][0] + Math.min(costBlue, costGreen);
            dp[1] = costs[i][1] + Math.min(costRed, costGreen);
            dp[2] = costs[i][2] + Math.min(costRed, costBlue);
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}
