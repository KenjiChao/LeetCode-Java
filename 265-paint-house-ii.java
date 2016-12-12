public class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        if (n == 0) return 0;
        int k = costs[0].length;
        int minIndex = 0, maxIndex = 1;
        int minCost = 0, maxCost = 0;

        for (int i = 0; i < n; i++) {
            int minIndexPrev = minIndex, maxIndexPrev = maxIndex;
            int minCostPrev = minCost, maxCostPrev = maxCost;
            minCost = Integer.MAX_VALUE;
            maxCost = Integer.MAX_VALUE;

            for (int j = 0; j < k; j++) {
                int cost = 0;
                if (minIndexPrev != j) {
                    cost = minCostPrev + costs[i][j];
                } else {
                    cost = maxCostPrev + costs[i][j];
                }

                if (cost < minCost) {
                    maxCost = minCost;
                    maxIndex = minIndex;
                    minCost = cost;
                    minIndex = j;
                } else if (cost < maxCost) {
                    maxCost = cost;
                    maxIndex = j;
                }
            }
        }
        return minCost;
    }
}
