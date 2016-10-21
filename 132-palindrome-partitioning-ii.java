// O(n) space
public class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] cut = new int[n + 1];
        for (int i = 0; i <= n; i++) cut[i] = i - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; i - j >= 0 && i + j < n && s.charAt(i - j) == s.charAt(i + j); j++) {
                cut[i + j + 1] = Math.min(cut[i + j + 1], cut[i - j] + 1);
            }
            for (int j = 0; i - j >= 0 && i + j + 1 < n && s.charAt(i - j) == s.charAt(i + j + 1); j++) {
                cut[i + j + 2] = Math.min(cut[i + j + 2], cut[i - j] + 1);
            }
        }
        return cut[n];
    }
}

// dp solution
public class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] cut = new int[n + 1];
        for (int i = 0; i <= n; i++) cut[i] = i - 1;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                dp[i][j] = (j - i <= 1 || dp[i + 1][j - 1]) && s.charAt(i) == s.charAt(j);
                if (dp[i][j]) cut[j + 1] = Math.min(cut[j + 1], cut[i] + 1);
            }
        }
        return cut[n];
    }
}
