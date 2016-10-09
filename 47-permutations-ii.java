public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        permutation(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    private void permutation(List<List<Integer>> res, List<Integer> cur, int[] nums, boolean[] used) {
        int n = nums.length;
        if (cur.size() == n) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;
            used[i] = true;
            cur.add(nums[i]);
            permutation(res, cur, nums, used);
            used[i] = false;
            cur.remove(cur.size() - 1);
        }
    }
}
