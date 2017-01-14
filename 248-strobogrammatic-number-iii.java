public class Solution {
    private static final char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};

    public int strobogrammaticInRange(String low, String high) {
        int[] count = {0};
        for (int len = low.length(); len <= high.length(); len++) {
            char[] c = new char[len];
            find(low, high, c, 0, len - 1, count);
        }
        return count[0];
    }

    private void find(String low, String high, char[] c, int left, int right, int[] count) {
        if (left > right) {
            String num = new String(c);
            if ((num.length() > low.length() || num.compareTo(low) >= 0)
                && (num.length() < high.length() || num.compareTo(high) <= 0)) count[0]++;
            return;
        }
        for (char[] p : pairs) {
            c[left] = p[0];
            c[right] = p[1];
            if (c.length != 1 && c[0] == '0') continue;
            if (left == right && p[0] != p[1]) continue;
            find(low, high, c, left + 1, right - 1, count);
        }
    }
}
