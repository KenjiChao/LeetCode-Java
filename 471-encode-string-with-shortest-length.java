public class Solution {
    public String encode(String s) {
        int len = s.length();
        String[][] dp = new String[len][len];
        for (int l = 1; l <= len; l++) {
            for (int i = 0; i + l - 1 < len; i++) {
                String substr = s.substring(i, i + l);
                dp[i][i + l - 1] = substr;
                // for length of substring <= 4, there is no better way to encode
                if (l > 4) {
                    // check if dp[i][j] + dp[j + 1][i + l - 1] is better than dp[i][i + l - 1]
                    for (int j = i; j < i + l - 1; j++) {
                        String candidate = dp[i][j] + dp[j + 1][i + l - 1];
                        if (candidate.length() < dp[i][i + l - 1].length()) {
                            dp[i][i + l - 1] = candidate;
                        }
                    }

                    // check if the substring itself can found a new pattern to encode
                    for (int j = i; j < i + l / 2; j++) {
                        String repeatStr = s.substring(i, j + 1);
                        if (l % (j - i + 1) == 0 && substr.replaceAll(repeatStr, "").equals("")) {
                            String candidate = String.valueOf(l / (j - i + 1)) + "[" + dp[i][j] + "]";
                            if (candidate.length() < dp[i][i + l - 1].length()) {
                                dp[i][i + l - 1] = candidate;
                            }
                        }
                    }
                }
            }
        }
        return dp[0][len - 1];
    }
}
