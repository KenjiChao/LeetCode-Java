public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) dp[i] = i;

        for (int i = 1; i <= m; i++) {
            int prev = dp[0];
            dp[0] = i;
            for (int j = 1; j <= n; j++) {
                int tmp = dp[j];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    dp[j] = 1 + Math.min(prev, Math.min(dp[j], dp[j - 1]));
                } else {
                    dp[j] = prev;
                }
                prev = tmp;
            }
        }
        return dp[n];
    }
}
