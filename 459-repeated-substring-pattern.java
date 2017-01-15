public class Solution {
    public boolean repeatedSubstringPattern(String str) {
        int len = str.length();
        for (int i = 1; i <= len / 2; i++) {
            if (len % i == 0) {
                int count = len / i;
                String pattern = str.substring(0, i);
                int j;
                for (j = 1; j < count; j++) {
                    if (!str.substring(i * j, i * j + i).equals(pattern)) break;
                }
                if (j == count) return true;
            }
        }
        return false;
    }
}
