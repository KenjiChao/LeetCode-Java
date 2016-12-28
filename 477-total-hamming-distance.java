public class Solution {
    public int totalHammingDistance(int[] nums) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < 32; i++) {
            int bitCount = 0;
            for (int j = 0; j < n; j++) {
                bitCount += (nums[j] >> i) & 1;
            }
            count += bitCount * (n - bitCount);
        }
        return count;
    }
}
