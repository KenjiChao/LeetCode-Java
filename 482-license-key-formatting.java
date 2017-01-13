public class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        for (int i = S.length() - 1; i >= 0; i--) {
            char ch = S.charAt(i);
            if (ch != '-') {
                if (sb.length() % (K + 1) == K) sb.append('-');
                sb.append(ch);
            }
        }
        return sb.reverse().toString().toUpperCase();
    }
}
