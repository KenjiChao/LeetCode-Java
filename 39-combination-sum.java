public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combination(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void combination(List<List<Integer>> res, List<Integer> cur, int[] candidates, int target, int start) {
        int n = candidates.length;
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < n && candidates[i] <= target; i++) {
            cur.add(candidates[i]);
            combination(res, cur, candidates, target - candidates[i], i);
            cur.remove(cur.size() - 1);
        }
    }
}
