public class Solution {
    public boolean isUgly(int num) {
        if (num == 0) return false;
        final int[] prime = {2, 3, 5};
        for (int i = 0; i < prime.length; i++) {
            while (num % prime[i] == 0) {
                num /= prime[i];
            }
        }
        return num == 1;
    }
}
