public class Solution {
    public int singleNumber(int[] nums) {
        // state: 00 -> 01 -> 10 -> 00
        int ones = 0; // first bit of the state
        int twos = 0; // second bit of the state
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}
