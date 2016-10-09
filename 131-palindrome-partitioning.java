public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), s, 0);
        return res;
    }

    private void backtrack(List<List<String>> res, List<String> cur, String s, int start) {
        int n = s.length();
        if (start == n) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < n; i++) {
            if (isPalindrome(s, start, i)) {
                cur.add(s.substring(start, i + 1));
                backtrack(res, cur, s, i + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int lo, int hi) {
        while (lo < hi) {
            if (s.charAt(lo++) != s.charAt(hi--)) return false;
        }
        return true;
    }
}
