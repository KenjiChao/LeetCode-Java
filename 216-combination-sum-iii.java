public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        combinations(res, new ArrayList<>(), k, n, 1);
        return res;
    }

    private void combinations(List<List<Integer>> res, List<Integer> cur, int k, int n, int num) {
        if (cur.size() == k) {
            if (n == 0) res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = num; i <= 9; i++) {
            cur.add(i);
            combinations(res, cur, k, n - i, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
