public class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i - maxLen - 1, i)) {
                res = s.substring(i - maxLen - 1, i + 1);
                maxLen += 2;
            } else if (isPalindrome(s, i - maxLen, i)) {
                res = s.substring(i - maxLen, i + 1);
                maxLen += 1;
            }
        }
        return res;
    }

    private boolean isPalindrome(String s, int lo, int hi) {
        if (lo < 0) return false;
        while (lo < hi) if (s.charAt(lo++) != s.charAt(hi--)) return false;
        return true;
    }
}
