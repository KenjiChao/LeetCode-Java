public class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            while (!stack.empty() && (i == heights.length || heights[i] < heights[stack.peek()])) {
                int h = heights[stack.pop()];
                int w = stack.empty() ? i : (i - stack.peek() - 1);
                maxArea = Math.max(maxArea, h * w);
            }

            if (i < heights.length) {
                if (!stack.empty() && heights[i] == heights[stack.peek()]) {
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return maxArea;
    }
}
