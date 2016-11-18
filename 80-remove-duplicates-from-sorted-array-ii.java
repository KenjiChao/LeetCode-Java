public class Solution {
    public int removeDuplicates(int[] nums) {
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (start < 2 || nums[i] > nums[start - 2]) {
                nums[start++] = nums[i];
            }
        }
        return start;
    }
}
