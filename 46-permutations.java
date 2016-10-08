public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permutation(res, nums, 0);
        return res;
    }

    private void permutation(List<List<Integer>> res, int[] nums, int start) {
        int n = nums.length;
        if (start == n) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) list.add(nums[i]);
            res.add(list);
            return;
        }
        for (int i = start; i < n; i++) {
            swap(nums, start, i);
            permutation(res, nums, start + 1);
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}
