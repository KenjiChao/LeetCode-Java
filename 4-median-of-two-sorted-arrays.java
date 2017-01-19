public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) return findMedianSortedArrays(nums2, nums1);
        int lo = 0, hi = m, half_len = (m + n + 1) / 2;
        while (lo <= hi) {
            int i = lo + (hi - lo) / 2;
            int j = half_len - i;
            if (i < m && nums2[j - 1] > nums1[i]) lo = i + 1;
            else if (i > 0 && nums1[i - 1] > nums2[j]) hi = i - 1;
            else {
                int left_max = Math.max(i > 0 ? nums1[i - 1] : Integer.MIN_VALUE, j > 0 ? nums2[j - 1] : Integer.MIN_VALUE);
                if ((m + n) % 2 == 1) return left_max;
                int right_min = Math.min(i < m ? nums1[i] : Integer.MAX_VALUE, j < n ? nums2[j] : Integer.MAX_VALUE);
                return ((double) left_max + (double) right_min) / 2;
            }
        }
        return -1;
    }
}
