public class Solution {
    public List<String> findStrobogrammatic(int n) {
        return find(n, n);
    }

    private List<String> find(int n, int m) {
        if (n == 0) return Arrays.asList("");
        if (n == 1) return Arrays.asList("0", "1", "8");
        List<String> ret = new ArrayList<>();
        for (String s : find(n - 2, m)) {
            if (n != m) ret.add("0" + s + "0");
            ret.add("1" + s + "1");
            ret.add("6" + s + "9");
            ret.add("8" + s + "8");
            ret.add("9" + s + "6");
        }
        return ret;
    }
}

// backtracking
public class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> ret = new ArrayList<>();
        find(ret, n, 0, new StringBuilder(), new StringBuilder());
        return ret;
    }

    private void find(List<String> ret, int n, int i, StringBuilder left, StringBuilder right) {
        if (i == n) {
            ret.add(left.toString() + right.toString());
            return;
        }
        if (n - i == 1) {
            for (char ch : "018".toCharArray()) {
                if (left.length() > 0 || ch != '0' || n == 1) {
                    left.append(ch);
                    find(ret, n, i + 1, left, right);
                    left.deleteCharAt(left.length() - 1);
                }
            }
        } else {
            String str = "69018";
            for (int j = 0; j < str.length(); j++) {
                char chL = str.charAt(j);
                char chR = j <= 1 ? str.charAt(1 - j) : chL;
                if (left.length() > 0 || chL != '0') {
                    left.append(chL);
                    right.insert(0, chR);
                    find(ret, n, i + 2, left, right);
                    left.deleteCharAt(left.length() - 1);
                    right.deleteCharAt(0);
                }
            }
        }
    }
}
