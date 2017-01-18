public class Solution {
    int minLen = Integer.MAX_VALUE;
    int minBit = 0;
    public String minAbbreviation(String target, String[] dictionary) {
        int len = target.length();
        List<Integer> dict = new ArrayList<>();
        int candidate = 0;
        StringBuilder sb = new StringBuilder();
        // Generate bit sequence
        for (String s : dictionary) {
            if (s.length() != len) continue;
            int seq = 0;
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) != target.charAt(i)) seq |= (1 << i);
            }
            dict.add(seq);
            candidate |= seq;
        }

        dfs(dict, len, candidate, 1, 0);

        // from seq to abbreviation word
        for (int i = 0; i < len; i++) {
            if ((minBit & (1 << i)) != 0) sb.append(target.charAt(i));
            else {
                int j = i;
                while (i < len && (minBit & (1 << i)) == 0) i++;
                sb.append(i - j);
                i--;
            }
        }
        return sb.toString();
    }

    private void dfs(List<Integer> dict, int n, int candidate, int bit, int mask) {
        int len = getAbbrLen(mask, n);
        if (len >= minLen) return;
        boolean match = true;
        for (Integer seq : dict) {
            if ((seq & mask) == 0) {
                match = false;
                break;
            }
        }
        if (match) {
            minLen = len;
            minBit = mask;
        } else {
            for (int b = bit; b < (1 << n); b <<= 1) {
                if ((candidate & b) != 0) dfs(dict, n, candidate, b << 1, mask + b);
            }
        }
    }

    private int getAbbrLen(int seq, int n) {
        int len = n;
        for (int b = 3; b < (1 << n); b <<= 1) {
            if ((seq & b) == 0) len--;
        }
        return len;
    }
}
