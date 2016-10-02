public class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        int[] primes = {2, 3, 5};
        int[] indices = {0, 0, 0};
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, dp[indices[j]] * primes[j]);
            }
            dp[i] = min;
            for (int j = 0; j < primes.length; j++) {
                if (dp[i] == dp[indices[j]] * primes[j]) {
                    indices[j]++;
                }
            }
        }
        return dp[n - 1];
    }
}
