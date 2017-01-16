// optimized version: sb.setLenth()
public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> ret = new ArrayList<>();
        generate(ret, word.toCharArray(), 0, 0, new StringBuilder());
        return ret;
    }

    private void generate(List<String> ret, char[] word, int index, int num, StringBuilder sb) {
        int len = sb.length();
        if (index == word.length) {
            if (num != 0) sb.append(num);
            ret.add(sb.toString());
        } else {
            generate(ret, word, index + 1, num + 1, sb);
            if (num != 0) sb.append(num);
            generate(ret, word, index + 1, 0, sb.append(word[index]));
        }
        sb.setLength(len);
    }
}

// traditional backtracking
public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> ret = new ArrayList<>();
        generate(ret, word, 0, new StringBuilder());
        return ret;
    }

    private void generate(List<String> ret, String word, int index, StringBuilder sb) {
        if (index == word.length()) {
            ret.add(sb.toString());
            return;
        }
        if (sb.length() == 0 || !Character.isDigit(sb.charAt(sb.length() - 1))) {
            for (int num = 1; num <= word.length() - index; num++) {
                sb.append(num);
                generate(ret, word, index + num, sb);
                while (sb.length() > 0 && Character.isDigit(sb.charAt(sb.length() - 1))) sb.deleteCharAt(sb.length() - 1);
            }
        }
        sb.append(word.charAt(index++));
        generate(ret, word, index, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
