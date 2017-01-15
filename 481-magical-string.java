public class Solution {
    public int magicalString(int n) {
        if (n <= 0) return 0;
        if (n <= 3) return 1;
        int[] nums = new int[n];
        nums[0] = 1; nums[1] = 2; nums[2] = 2;
        int count = 1, slow = 2, fast = 3, fill = 1;
        while (fast < n) {
            int repeat = Math.min(nums[slow], n - fast);
            if (fill == 1) count += repeat;
            for (int i = 0; i < repeat; i++, fast++) nums[fast] = fill;
            fill ^= 3;
            slow++;
        }
        return count;
    }
}
