public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            count += twoSumSmaller(nums, i + 1, target - nums[i]);
        }
        return count;
    }

    private int twoSumSmaller(int[] nums, int start, int target) {
        int count = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] < target) {
                count += end - start;
                start++;
            } else {
                end--;
            }
        }
        return count;
    }
}
