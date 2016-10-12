public class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int i = 0, j = n - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;
        while (i <= j) {
            if (leftMax <= rightMax) {
                water += leftMax > height[i] ? leftMax - height[i] : 0;
                leftMax = Math.max(leftMax, height[i++]);
            } else {
                water += rightMax > height[j] ? rightMax - height[j] : 0;
                rightMax = Math.max(rightMax, height[j--]);
            }
        }
        return water;
    }
}
