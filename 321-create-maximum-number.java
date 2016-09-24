public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] res = new int[k];
        for (int i = 0; i <= k; i++) {
            if (i <= m && (k - i) <= n) {
                int[] candidate = merge(maxNumberOneD(nums1, i), maxNumberOneD(nums2, k - i), k);
                if (greater(candidate, 0, res, 0)) res = candidate;
            }
        }
        return res;
    }

    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; r++) {
            res[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return res;
    }

    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    private int[] maxNumberOneD(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[k];
        for (int i = 0, j = 0; i < n; i++) {
            while (j + n - i > k && j > 0 && res[j - 1] < nums[i]) {
                j--;
            }
            if (j < k) {
                res[j++] = nums[i];
            }
        }
        return res;
    }
}
