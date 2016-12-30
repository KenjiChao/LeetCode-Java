// recursive
public class Solution {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p));
        } else {
            return !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
        }
    }
}

// iterative
public class Solution {
    public boolean isMatch(String s, String p) {
        /**
         * dp[i][j] is true if s[0..i-1] matches p[0..j-1]
         * init: dp[0][0] is true
         * if p[j - 1] != '*'
         *      dp[i][j] = dp[i - 1][j - 1] && s[i - 1] == p[j - 1]
         * else
         *      dp[i][j] is true iff any of the following is true (denote p[j - 2] with x):
         *      1) x* repeats 0 time: dp[i][j - 2] is true
         *      2) x* repeats >= 1 times: dp[i][j] = dp[i - 1][j] && s[i - 1] == p[j - 2]
         */
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 2; j <= n; j++) {
            dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 2];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) != '*') {
                    dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                } else {
                    dp[i][j] = dp[i][j - 2] || (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }
}
