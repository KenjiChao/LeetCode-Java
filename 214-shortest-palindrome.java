public class Solution {
    public String shortestPalindrome(String s) {
        String str = s + "#" + new StringBuilder(s).reverse().toString();
        int[] prefix = getPrefixTable(str);
        return new StringBuilder(s.substring(prefix[prefix.length - 1])).reverse().toString() + s;
    }

    private int[] getPrefixTable(String s) {
        int[] prefix = new int[s.length()];
        int index = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(index) == s.charAt(i)) {
                prefix[i] = prefix[i - 1] + 1;
                index++;
            } else {
                index = prefix[i - 1];
                while (index > 0 && s.charAt(index) != s.charAt(i)) index = prefix[index - 1];
                if (s.charAt(index) == s.charAt(i)) index++;
                prefix[i] = index;
            }
        }
        return prefix;
    }
}
