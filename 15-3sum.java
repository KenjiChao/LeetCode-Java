public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                twoSum(res, nums, i);
            }
        }
        return res;
    }

    private void twoSum(List<List<Integer>> res, int[] nums, int i) {
        int target = -nums[i];
        int n = nums.length;
        int lo = i + 1;
        int hi = n - 1;
        while (lo < hi) {
            if (nums[lo] + nums[hi] == target) {
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
                while (lo < hi && nums[lo] == nums[lo - 1]) lo++;
                while (lo < hi && nums[hi] == nums[hi + 1]) hi--;
            } else if (nums[lo] + nums[hi] < target) {
                lo++;
            } else {
                hi--;
            }
        }
    }
}
