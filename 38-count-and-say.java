public class Solution {
    public String countAndSay(int n) {
        String str = "1";
        while (--n > 0) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            char say = str.charAt(0);
            for (int i = 1; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == say) {
                    count++;
                } else {
                    sb.append(count).append(say);
                    count = 1;
                    say = ch;
                }
            }
            sb.append(count).append(say);
            str = sb.toString();
        }
        return str;
    }
}
