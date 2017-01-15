// optimized version
public class Solution {
    public int findNthDigit(int n) {
        int len = 1, start = 1;
        while (n / len / start > 9) {
            n -= 9 * start * len;
            start *= 10;
            len++;
        }
        return String.valueOf(start + (n - 1) / len).charAt((n - 1) % len) - '0';
    }
}

public class Solution {
    public int findNthDigit(int n) {
        int len = 1, count = 9, total = 0;
        while (n / len > count) {
            n -= count * len;
            total += count;
            count *= 10;
            len++;
        }
        total += 1 + (n - 1) / len;
        n = (n - 1) % len;
        return String.valueOf(total).charAt(n) - '0';
    }
}
