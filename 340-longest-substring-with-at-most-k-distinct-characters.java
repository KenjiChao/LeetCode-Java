public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int size = 0, start = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)]++ == 0) size++;
            if (size > k) {
                while (--count[s.charAt(start++)] > 0);
                size--;
            }
            res = Math.max(res, i - start + 1);
        }
        return res;
    }
}
