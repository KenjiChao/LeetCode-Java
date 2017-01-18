public class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (k == 0 || nums.length == 0) return new double[1];
        int n = nums.length;
        List<Double> window = new ArrayList<>();
        double[] ret = new double[n - k + 1];
        for (int i = 0; i < n; i++) {
            if (i >= k) window.remove(Collections.binarySearch(window, (double) nums[i - k]));
            int index = Collections.binarySearch(window, (double) nums[i]);
            if (index < 0) index = -index - 1;
            window.add(index, (double) nums[i]);
            if (i >= k - 1) {
                ret[i - k + 1] = k % 2 == 0 ? window.get(k / 2 - 1) / 2 + window.get(k / 2) / 2 : window.get(k / 2);
            }
        }
        return ret;
    }
}
