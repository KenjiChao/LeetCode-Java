public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        int n = s.length();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                res.add(s.substring(0, i) + "--" + s.substring(i + 2));
            }
        }
        return res;
    }
}
