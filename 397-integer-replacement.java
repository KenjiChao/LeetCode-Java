public class Solution {
    public int integerReplacement(int n) {
        if (n <= 0) return 0;
        int count = 0;
        while (n != 1) {
            if ((n & 1) == 0) n >>>= 1;
            else n += n == 3 || (n >>> 1 & 1) == 0 ? -1 : 1;
            count++;
        }
        return count;
    }
}
