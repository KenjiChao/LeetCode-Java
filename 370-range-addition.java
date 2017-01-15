public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] nums = new int[length];
        for (int[] update : updates) {
            nums[update[0]] += update[2];
            if (update[1] + 1 < nums.length) nums[update[1] + 1] -= update[2];
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            nums[i] = sum;
        }
        return nums;
    }
}
