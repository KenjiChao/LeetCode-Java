public class Solution {
    public String rearrangeString(String str, int k) {
        int[] freq = new int[256];
        int[] valid = new int[256];
        for (char ch : str.toCharArray()) freq[ch]++;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int candidate = findValidMax(freq, valid, i);
            if (candidate == -1) return "";
            freq[candidate]--;
            valid[candidate] = i + k;
            sb.append((char) candidate);
        }
        return sb.toString();
    }

    private int findValidMax(int[] freq, int[] valid, int index) {
        int candidate = -1;
        int max = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > max && valid[i] <= index) {
                max = freq[i];
                candidate = i;
            }
        }
        return candidate;
    }
}
