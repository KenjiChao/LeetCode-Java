public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> ret = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String s : strings) {
            String key = convert(s);
            if (!map.containsKey(key)) {
                map.put(key, ret.size());
                ret.add(new ArrayList<>());
            }
            ret.get(map.get(key)).add(s);
        }
        return ret;
    }

    private String convert(String s) {
        if (s.length() == 0) return s;
        char[] chars = s.toCharArray();
        int offset = chars[0] - 'a';
        for (int i = 0; i < chars.length; i++) {
            chars[i] -= offset;
            if (chars[i] < 'a') chars[i] += 26;
        }
        return new String(chars);
    }
}
