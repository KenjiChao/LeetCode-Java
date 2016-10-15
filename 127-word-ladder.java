public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        int level = 1;
        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> set = new HashSet<>();
            for (String word : beginSet) {
                for (int i = 0; i < word.length(); i++) {
                    char old = word.charAt(i);
                    StringBuilder sb = new StringBuilder(word);
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch != old) {
                            sb.setCharAt(i, ch);
                            String next = sb.toString();
                            if (endSet.contains(next)) return level + 1;
                            if (!visited.contains(next) && wordList.contains(next)) {
                                visited.add(next);
                                set.add(next);
                            }
                        }
                    }
                }
            }
            beginSet = set;
            level++;
        }
        return 0;
    }
}
