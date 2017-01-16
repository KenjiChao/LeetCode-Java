public class Solution {
    public boolean canWin(String s) {
        return canWin(s.toCharArray());
    }

    private boolean canWin(char[] chars) {
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == '+' && chars[i + 1] == '+') {
                chars[i] = chars[i + 1] = '-';
                boolean win = !canWin(chars);
                chars[i] = chars[i + 1] = '+';
                if (win) return true;
            }
        }
        return false;
    }
}
