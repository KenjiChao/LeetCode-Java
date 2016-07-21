public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;

        int left = 1, right = num / 2;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;
            if (square == num) {
                return true;
            } else if (square < num) {
                left = (int) mid + 1;
            } else {
                right = (int) mid - 1;
            }
        }

        return false;
    }
}
