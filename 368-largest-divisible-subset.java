public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] parent = new int[nums.length];
        int max = 0;
        int maxi = 0;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && dp[i] < 1 + dp[j]) {
                    parent[i] = j;
                    dp[i] = 1 + dp[j];

                    if (dp[i] > max) {
                        max = dp[i];
                        maxi = i;
                    }
                }
            }
        }

        for (int i = 0; i < max; i++) {
            result.add(0, nums[maxi]);
            maxi = parent[maxi];
        }

        return result;
    }
}
