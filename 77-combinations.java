public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combinations(res, new ArrayList<>(), 1, n, k);
        return res;
    }

    private void combinations(List<List<Integer>> res, List<Integer> cur, int start, int n, int k) {
        if (k == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (n - start + 1 < k) return;
        for (int i = start; i <= n; i++) {
            cur.add(i);
            combinations(res, cur, i + 1, n, k - 1);
            cur.remove(cur.size() - 1);
        }
    }
}
