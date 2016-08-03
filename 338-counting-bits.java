// f[i] = f[i / 2] + i % 2
public class Solution {
    public int[] countBits(int num) {
        int[] ret = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            ret[i] = ret[i >> 1] + (i & 1);
        }

        return ret;
    }
}

public class Solution {
    public int[] countBits(int num) {
        int[] ret = new int[num + 1];
        int pow = 1;
        for (int i = 1, j = 0; i <= num; i++, j++) {
            if (j == pow) {
                pow *= 2;
                j = 0;
            }
            ret[i] = ret[j] + 1;
        }

        return ret;
    }
}
