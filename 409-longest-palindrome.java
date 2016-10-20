public class Solution {
    public int longestPalindrome(String s) {
        int[] histogram = new int[256];
        for (int i = 0; i < s.length(); i++) {
            histogram[s.charAt(i)]++;
        }
        int odd = 0;
        for (int i = 0; i < 256; i++) {
            if (histogram[i] % 2 == 1) odd++;
        }
        return s.length() - (odd > 1 ? odd - 1 : 0);
    }
}
