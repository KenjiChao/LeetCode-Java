public class Solution {
    public String minWindow(String s, String t) {
        int[] histogram = new int[256];
        for (char ch : t.toCharArray()) {
            histogram[ch]++;
        }
        int count = t.length();
        int begin = 0, end = 0, min = Integer.MAX_VALUE, index = 0;
        while (end < s.length()) {
            if (histogram[s.charAt(end++)]-- > 0) count--;
            while (count == 0) {
                if (end - begin < min) {
                    min = end - begin;
                    index = begin;
                }
                if (histogram[s.charAt(begin++)]++ == 0) count++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(index, index + min);
    }
}
