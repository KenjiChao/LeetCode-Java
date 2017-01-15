public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) nums[(nums[i] - 1) % n] += n;
        for (int i = 0; i < n; i++) if (nums[i] <= n) ret.add(i + 1);
        return ret;
    }
}
