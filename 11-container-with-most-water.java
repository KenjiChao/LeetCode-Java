public class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, max = 0;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            max = Math.max(max, (right - left) * h);
            while (height[left] <= h && left < right) {
                left++;
            }
            while (height[right] <= h && left < right) {
                right--;
            }
        }
        return max;
    }
}
