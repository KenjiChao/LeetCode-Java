public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int ret = 1, base = 9;
        for (int i = 1; i <= Math.min(n, 10); i++) {
            ret += base;
            base *= (10 - i);
        }

        return ret;
    }
}
