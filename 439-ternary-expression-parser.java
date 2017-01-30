public class Solution {
    public String parseTernary(String expression) {
        Stack<Character> stack = new Stack<>();
        for (int i = expression.length() - 1; i >= 0; i--) {
            char ch = expression.charAt(i);
            if (!stack.isEmpty() && stack.peek() == '?') {
                stack.pop(); // '?'
                char first = stack.pop();
                stack.pop(); // ':'
                char second = stack.pop();
                stack.push(ch == 'T' ? first : second);
            } else {
                stack.push(ch);
            }
        }
        return String.valueOf(stack.pop());
    }
}
