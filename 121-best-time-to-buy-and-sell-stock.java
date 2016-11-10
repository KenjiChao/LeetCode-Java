public class Solution {
    public int maxProfit(int[] prices) {
        int maxEndingHere = 0;
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            maxEndingHere = Math.max(0, maxEndingHere += prices[i] - prices[i - 1]);
            max = Math.max(max, maxEndingHere);
        }
        return max;
    }
}
