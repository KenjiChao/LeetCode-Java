public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> res = new HashSet<>();
        int rmL = 0, rmR = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') rmL++;
            else if (s.charAt(i) == ')') {
                if (rmL > 0) rmL--;
                else rmR++;
            }
        }
        dfs(res, s, 0, rmL, rmR, 0, new StringBuilder());
        return new ArrayList<>(res);
    }

    private void dfs(Set<String> res, String s, int index, int rmL, int rmR, int open, StringBuilder sb) {
        if (index == s.length() && rmL == 0 && rmR == 0 && open == 0) {
            res.add(sb.toString());
            return;
        }
        if (index == s.length() || rmL < 0 || rmR < 0 || open < 0) return;
        char ch = s.charAt(index);
        int len = sb.length();
        if (ch == '(') {
            dfs(res, s, index + 1, rmL - 1, rmR, open, sb);
            dfs(res, s, index + 1, rmL, rmR, open + 1, sb.append(ch));
        } else if (ch == ')') {
            dfs(res, s, index + 1, rmL, rmR - 1, open, sb);
            dfs(res, s, index + 1, rmL, rmR, open - 1, sb.append(ch));
        } else {
            dfs(res, s, index + 1, rmL, rmR, open, sb.append(ch));
        }
        sb.setLength(len);
    }
}
