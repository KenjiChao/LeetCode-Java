public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int sqrt = (int) Math.floor(Math.sqrt(n));
        for (int i = 1; i <= sqrt; i++) {
            int num = i * i;
            for (int j = num; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - num] + 1);
            }
        }
        return dp[n];
    }
}
