public class Solution {
    public boolean isSelfCrossing(int[] x) {
        if (x != null && x.length < 4) return false;

        for (int i = 3; i < x.length; i++) {
            if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3]) {
                // ith line crosses (i - 3)th line
                return true;
            }

            if (i >= 4 && x[i] + x[i - 4] >= x[i - 2] && x[i - 1] == x[i - 3]) {
                // ith line crosses (i - 4)th line
                return true;
            }

            if (i >= 5 && x[i - 3] >= x[i - 5] && x[i - 2] >= x[i - 4]
				&& x[i - 1] + x[i -5] >= x[i - 3] && x[i - 1] <= x[i - 3] && x[i] + x[i - 4] >= x[i - 2]) {
                // ith line crosses (i - 5)th line
                return true;
            }
        }

        return false;
    }
}
