public class Solution {
    public int splitArray(int[] nums, int m) {
        long l = 0, r = 0;
        for (int num : nums) {
            l = Math.max(l, num);
            r += num;
        }
        if (m == 1) return (int) r;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (lowerTarget(nums, m, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) l;
    }

    private boolean lowerTarget(int[] nums, int m, long target) {
        int count = 1;
        long sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum > target) {
                sum = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
}
