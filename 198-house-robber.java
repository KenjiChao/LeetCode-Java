public class Solution {
    public int rob(int[] nums) {
        int robCur = 0;
        int robPrev = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = robPrev;
            robPrev = Math.max(robPrev, robCur);
            robCur = nums[i] + temp;
        }
        return Math.max(robPrev, robCur);
    }
}
