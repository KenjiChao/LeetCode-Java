public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        int i = 0;
        while (i < n) {
            List<String> line = new ArrayList<>();
            line.add(words[i]);
            int len = words[i++].length();
            while (i < n && len + words[i].length() + 1 <= maxWidth) {
                line.add(words[i]);
                len += words[i++].length() + 1;
            }
            int extra = maxWidth - len;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < line.size(); j++) {
                if (j > 0) {
                    int spaces = (i < n) ? 1 + extra / (line.size() - 1) + (j <= (extra % (line.size() - 1)) ? 1 : 0) : 1;
                    while (spaces-- > 0) sb.append(" ");
                }
                sb.append(line.get(j));
            }
            while (sb.length() < maxWidth) sb.append(" ");
            res.add(sb.toString());
        }
        return res;
    }
}
