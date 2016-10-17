public class Solution {
    public boolean isHappy(int n) {
        int slow = squareSum(n), fast = squareSum(slow);
        while (slow != fast) {
            slow = squareSum(slow);
            fast = squareSum(fast);
            fast = squareSum(fast);
        }
        return slow == 1;
    }

    private int squareSum(int n) {
        int sum = 0;
        while (n != 0) {
            int temp = n % 10;
            sum += temp * temp;
            n /= 10;
        }
        return sum;
    }
}
