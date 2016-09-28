public class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; n - i - j >= Math.max(i, j); j++) {
                if (isValid(num, i, j)) return true;
            }
        }
        return false;
    }

    private boolean isValid(String num, int i, int j) {
        if (num.charAt(0) == '0' && i > 1) return false;
        if (num.charAt(i) == '0' && j > 1) return false;
        Long num1 = Long.parseLong(num.substring(0, i));
        Long num2 = Long.parseLong(num.substring(i, i + j));
        String sum = "";
        for (int k = i + j; k < num.length(); k += sum.length()) {
            num2 += num1;
            num1 = num2 - num1;
            sum = num2.toString();
            if (!num.startsWith(sum, k)) return false;
        }
        return true;
    }
}
