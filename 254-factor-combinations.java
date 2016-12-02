public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        factors(res, new ArrayList<>(), 2, n);
        return res;
    }

    private void factors(List<List<Integer>> res, List<Integer> cur, int start, int n) {
        for (int i = start; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                cur.add(i);
                cur.add(n / i);
                res.add(new ArrayList<>(cur));
                cur.remove(cur.size() - 1);
                factors(res, cur, i, n / i);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
