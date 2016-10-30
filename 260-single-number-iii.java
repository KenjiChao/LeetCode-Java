public class Solution {
    public int[] singleNumber(int[] nums) {
        int ones = 0;
        for (int num : nums) {
            ones ^= num;
        }
        // get the right most bit
        ones &= -ones;

        int[] res = {0, 0};
        for (int num : nums) {
            if ((num & ones) != 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}
