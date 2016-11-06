public class Solution {
    public int minArea(char[][] image, int x, int y) {
        int m = image.length;
        if (m == 0) return 0;
        int n = image[0].length;
        int left = searchCol(image, 0, y, 0, m, true);
        int right = searchCol(image, y + 1, n, 0, m, false);
        int top = searchRow(image, 0, x, left, right, true);
        int bottom = searchRow(image, x + 1, m, left, right, false);
        return (right - left) * (bottom - top);
    }

    private int searchCol(char[][] image, int lo, int hi, int start, int end, boolean fromLeft) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int k = start;
            while (k < end && image[k][mid] != '1') k++;
            if ((k == end) == fromLeft) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private int searchRow(char[][] image, int lo, int hi, int start, int end, boolean fromTop) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int k = start;
            while (k < end && image[mid][k] != '1') k++;
            if ((k == end) == fromTop) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
