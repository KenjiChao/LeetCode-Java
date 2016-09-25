public class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        long[] values = new long[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                values[i] |= (1 << (words[i].charAt(j) - 'A'));
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((values[i] & values[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
