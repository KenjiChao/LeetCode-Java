public class Solution {
    public String removeKdigits(String num, int k) {
        char[] nums = new char[num.length()];
        int idx = 0, nonzero = -1, digits = num.length() - k;
        for (char ch : num.toCharArray()) {
            while (idx > 0 && nums[idx - 1] > ch && k > 0) {
                k--;
                idx--;
                if (nonzero == idx) {
                    if (idx == 0 || nums[idx - 1] == '0') nonzero = -1;
                    else nonzero--;
                }
            }
            if (ch > '0' && nonzero == -1) nonzero = idx;
            nums[idx++] = ch;
        }
        return nonzero == digits || nonzero == -1 ? "0" : new String(nums, nonzero, digits - nonzero);
    }
}
