public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int ret = 0, num = 0, sign = 1;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = 10 * num + (ch - '0');
            } else if (ch == '+') {
                ret += sign * num;
                num = 0;
                sign = 1;
            } else if (ch == '-') {
                ret += sign * num;
                num = 0;
                sign = -1;
            } else if (ch == '(') {
                stack.push(ret);
                stack.push(sign);
                ret = 0;
                sign = 1;
            } else if (ch == ')') {
                ret += sign * num;
                num = 0;
                ret *= stack.pop(); // sign
                ret += stack.pop(); // previous result
            }
        }
        if (num != 0) ret += sign * num;
        return ret;
    }
}
