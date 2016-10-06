public class Solution {
    public String addBinary(String a, String b) {
        int m = a.length() - 1;
        int n = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (m >= 0 || n >= 0 || carry == 1) {
            carry += m >= 0 ? a.charAt(m--) - '0' : 0;
            carry += n >= 0 ? b.charAt(n--) - '0' : 0;
            sb.append(carry % 2);
            carry /= 2;
        }
        return sb.reverse().toString();
    }
}
