public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int n = nums.length;
        if (n == 0) return res;
        for (int i = 0; i < n; i++) {
            int start = i;
            while (i + 1 < n && nums[i + 1] == nums[i] + 1) i++;
            if (start == i) {
                res.add(String.valueOf(nums[start]));
            } else {
                res.add(String.valueOf(nums[start] + "->" + nums[i]));
            }
        }
        return res;
    }
}
