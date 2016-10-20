public class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] histogram = new int[256];
        for (int i = 0; i < s.length(); i++) {
            histogram[s.charAt(i)]++;
        }
        int odd = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (histogram[ch] % 2 == 1) odd++;
            if (histogram[ch - 'a' + 'A'] % 2 == 1) odd++;
            if (odd > 1) return false;
        }
        return true;
    }
}
