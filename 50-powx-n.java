public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        double res = myPow(x, n / 2);
        return n % 2 == 0 ? res * res : n > 0 ? x * res * res : 1 / x * res * res;
    }
}
