public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        if (n == 0) return 0;
        int lo = 0;
        int hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (citations[mid] > n - mid) {
                hi = mid;
            } else if (citations[mid] < n - mid) {
                lo = mid + 1;
            } else {
                return n - mid;
            }
        }
        return n - lo;
    }
}
