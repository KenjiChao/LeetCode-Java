public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combination(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void combination(List<List<Integer>> res, List<Integer> cur, int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            cur.add(candidates[i]);
            combination(res, cur, candidates, target - candidates[i], i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
