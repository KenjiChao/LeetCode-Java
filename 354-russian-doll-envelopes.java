public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length < 2) {
            return 0;
        }

        int n = envelopes.length;
        // Sort the array. Ascend on width and descend on height if width are same
        Arrays.sort(envelopes, new Comparator<int[]>() {
                @Override
                public int compare(int[] arr1, int[] arr2) {
                    if (arr1[0] != arr2[0]) {
                        return arr1[0] - arr2[0];
                    } else {
                        return arr2[1] - arr1[1];
                    }
                }
            });

        // Find the longest increasing subsequence based on height
        int[] dp = new int[n];
        int len = 0;
        for (int i = 0; i < n; i++) {
            int index = Arrays.binarySearch(dp, 0, len, envelopes[i][1]);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = envelopes[i][1];
            if (index == len) len++;
        }

        return len;
    }
}
