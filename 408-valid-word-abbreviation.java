public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int j = 0, count = 0;
        for (int i = 0; i < abbr.length(); i++) {
            char ch = abbr.charAt(i);
            if (Character.isDigit(ch)) {
                if (count == 0 && ch == '0') return false;
                count = count * 10 + ch - '0';
            } else {
                j += count;
                count = 0;
                if (j >= word.length() || ch != word.charAt(j++)) return false;
            }
        }
        j += count;
        return j == word.length();
    }
}
