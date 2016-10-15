public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> neighbors = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        int min = Integer.MAX_VALUE;
        wordList.add(beginWord);
        for (String word : wordList) {
            neighbors.put(word, new ArrayList<>());
            distance.put(word, Integer.MAX_VALUE);
        }
        distance.put(beginWord, 0);
        wordList.add(endWord);

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        while (!q.isEmpty()) {
            String word = q.poll();
            System.out.println(word);
            int level = distance.get(word) + 1;
            if (level > min) break;

            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                char oldch = word.charAt(i);
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (ch != oldch) {
                        sb.setCharAt(i, ch);
                        String next = sb.toString();
                        if (wordList.contains(next) && level <= distance.get(next)) {
                            if (next.equals(endWord)) min = level;
                            else if (level < distance.get(next)) q.add(next);
                            distance.put(next, level);
                            neighbors.get(word).add(next);
                        }
                    }
                }
            }
        }
        if (min == Integer.MAX_VALUE) return res;
        dfs(res, neighbors, beginWord, endWord, new ArrayList<>());
        return res;
    }

    private void dfs(List<List<String>> res, Map<String, List<String>> neighbors, String word, String endWord, List<String> path) {
        path.add(word);
        if (word.equals(endWord)) {
            res.add(new ArrayList<>(path));
        } else {
            for (String neighbor : neighbors.get(word)) dfs(res, neighbors, neighbor, endWord, path);
        }
        path.remove(path.size() - 1);
    }
}
