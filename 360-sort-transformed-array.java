public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] ret = new int[n];
        int x1 = 0, x2 = n - 1;
        int index = a >= 0 ? n - 1 : 0;
        while (x1 <= x2) {
            if (a >= 0) {
                ret[index--] = func(a, b, c, nums[x1]) >= func(a, b, c, nums[x2]) ? func(a, b, c, nums[x1++]) : func(a, b, c, nums[x2--]);
            } else {
                ret[index++] = func(a, b, c, nums[x1]) <= func(a, b, c, nums[x2]) ? func(a, b, c, nums[x1++]) : func(a, b, c, nums[x2--]);
            }
        }
        return ret;
    }

    private int func(int a, int b, int c, int x) {
        return a * x * x + b * x + c;
    }
}
