public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) return false;
        if (x == z || y == z || x + y == z) return true;

        return z % gcd(x, y) == 0;
    }

    private int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }
}
