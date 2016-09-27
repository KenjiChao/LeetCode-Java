public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(list, n, 0, "");
        return list;
    }

    private void generate(List<String> list, int n, int m, String str) {
        if (n == 0 && m == 0) {
            list.add(str);
            return;
        }
        if (n > 0) {
            generate(list, n - 1, m + 1, str + "(");
        }

        if (m > 0) {
            generate(list, n, m - 1, str + ")");
        }
    }
}
