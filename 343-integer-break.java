public class Solution {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;

        int max = 1;
        while (n >= 5) {
            max *= 3;
            n -= 3;
        }
        max *= n;

        return max;
    }
}
