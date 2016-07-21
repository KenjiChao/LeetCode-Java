public class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 2][n + 2];

        for (int j = 2; j <= n; j++) {
            int k0 = j - 1;
            Deque<Pair> dq = new LinkedList();

            for (int i = j - 1; i > 0; i--) {
                while (dp[i][k0 - 1] > dp[k0 + 1][j]) {
                    if (!dq.isEmpty() && dq.peekFirst().start == k0) {
                        dq.removeFirst();
                    }
                    k0--;
                }
                int val = i + dp[i + 1][j];
                while (!dq.isEmpty() && val < dq.peekLast().val) {
                    dq.removeLast();
                }
                dq.addLast(new Pair(i, val));
                dp[i][j] = Math.min(dp[i][k0] + k0 + 1, dq.peekFirst().val);
            }
        }

        return dp[1][n];
    }

    private class Pair {
        int start;
        int val;

        Pair(int start, int val) {
            this.start = start;
            this.val = val;
        }
    }
}
