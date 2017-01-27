public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<>();
        generateIpAddresses(ret, s, new StringBuilder(), 0, 0);
        return ret;
    }

    private void generateIpAddresses(List<String> ret, String s, StringBuilder sb, int index, int colons) {
        if (colons > 4) return;
        if (colons == 4 && index == s.length()) ret.add(sb.toString());

        for (int i = 1; i < 4 && index + i <= s.length(); i++) {
            String ip = s.substring(index, index + i);
            if ((ip.length() > 1 && ip.charAt(0) == '0') || Integer.parseInt(ip) > 255) continue;
            int len = sb.length();
            sb.append(colons > 0 ? "." : "").append(ip);
            generateIpAddresses(ret, s, sb, index + i, colons + 1);
            sb.setLength(len);
        }
    }
}
