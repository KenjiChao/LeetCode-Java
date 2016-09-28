public class Solution {
    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        int[] histogram = new int[26];
        for (int i = 0; i < n; i++) {
            histogram[chars[i] - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            histogram[chars[i] - 'a']--;
            if (sb.indexOf(chars[i] + "") == -1) {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > chars[i]
                    && histogram[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
