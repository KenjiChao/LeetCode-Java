// optimized recursive
public class Solution {
    public String decodeString(String s) {
        int[] i = {0};
        return decodeString(s, i);
    }

    public String decodeString(String s, int[] i) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        while (i[0] < len) {
            char ch = s.charAt(i[0]);
            if (Character.isDigit(ch)) {
                int n = 0;
                do {
                    n = 10 * n + s.charAt(i[0]++) - '0';
                } while (i[0] < len && Character.isDigit(s.charAt(i[0])));
                i[0]++; // advance over '['
                String sub = decodeString(s, i);
                while (n-- > 0) sb.append(sub);
            } else if (ch == ']') {
                i[0]++;
                return sb.toString();
            } else sb.append(s.charAt(i[0]++));
        }
        return sb.toString();
    }
}

// recursive
public class Solution {
    public String decodeString(String s) {
        String ret = "";
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (!Character.isDigit(ch)) ret += ch;
            else {
                int n = 0;
                do {
                    n = 10 * n + s.charAt(i++) - '0';
                } while (i < len && Character.isDigit(s.charAt(i)));
                i++; // advance over '['
                int j = i;
                int left = 1;
                boolean containsLeft = false;
                while (left > 0) {
                    if (s.charAt(j) == '[') {
                        left++;
                        containsLeft = true;
                    } else if (s.charAt(j) == ']') {
                        left--;
                    }
                    j++;
                }
                String sub = s.substring(i, j - 1);
                if (containsLeft) sub = decodeString(sub);
                while (n-- > 0) ret += sub;
                i = j - 1;
            }
        }
        return ret;
    }
}
