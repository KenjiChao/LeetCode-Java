public class NumArray {
    int[] dp;

    public NumArray(int[] nums) {
        int len = nums.length;
        dp = new int[len + 1];
        for (int i = 0; i < len; i++) {
            dp[i + 1] = dp[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i > j) return 0;
        return dp[j + 1] - dp[i];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
