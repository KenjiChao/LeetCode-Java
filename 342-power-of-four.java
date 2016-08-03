// O(1) without loops
public class Solution {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
        // 0x55555555 is to get rid of those power of 2 but not power of 4
    }
}

// O(1)
public class Solution {
    public boolean isPowerOfFour(int num) {
        if (num <= 0 || (num & (num - 1)) != 0) return false;
        int leastBit = num & ~(num - 1);
        while (leastBit != 0 && leastBit != 1) {
            leastBit >>= 2;
        }
        return leastBit == 1;
    }
}
