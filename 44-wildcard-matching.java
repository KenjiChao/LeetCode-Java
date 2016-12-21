public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        int i = 0, j = 0, matchi = 0, matchj = -1;
        while (i < m) {
            if (j < n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                // advancing both pointers
                i++;
                j++;
            } else if (j < n && p.charAt(j) == '*') {
                // * found, only advancing the pointer of p
                matchi = i;
                matchj = j;
                j++;
            } else if (matchj != -1) {
                // found * before, advancing the pointer of s from last matched pointer
                i = ++matchi;
                j = matchj + 1;
            } else {
                return false;
            }
        }

        while (j < n && p.charAt(j) == '*') j++;
        return j == n;
    }
}
