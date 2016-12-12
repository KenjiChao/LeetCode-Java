public class Solution {
    public int numWays(int n, int k) {
        if (n < 1) return 0;
        int sameColorCount = 0, diffColorCount = k;
        for (int i = 1; i < n; i++) {
            int prevSameColorCount = sameColorCount;
            sameColorCount = diffColorCount;
            diffColorCount = (prevSameColorCount + diffColorCount) * (k - 1);
        }
        return sameColorCount + diffColorCount;
    }
}
