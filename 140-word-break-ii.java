public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return generate(s, wordDict, new HashMap<>());
    }

    private List<String> generate(String s, List<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) return map.get(s);
        List<String> ret = new ArrayList<>();
        if (s.length() == 0) {
            ret.add(s);
            return ret;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> right = generate(s.substring(word.length()), wordDict, map);
                for (String str : right) {
                    ret.add(word + (str.length() == 0 ? "" : " ") + str);
                }
            }
        }
        map.put(s, ret);
        return ret;
    }
}
