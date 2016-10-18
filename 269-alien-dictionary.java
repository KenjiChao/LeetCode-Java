public class Solution {
    public String alienOrder(String[] words) {
        if (words.length == 0) return "";
        int[] degree = new int[26];
        List<List<Character>> graph = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        for (Character ch : words[0].toCharArray()) set.add(ch);
        for (int i = 0; i < 26; i++) graph.add(new ArrayList<>());
        for (int i = 1; i < words.length; i++) {
            if (words[i - 1].startsWith(words[i]) && words[i - 1].length() > words[i].length()) return "";
            for (Character ch : words[i].toCharArray()) set.add(ch);
            if (words[i].startsWith(words[i - 1])) continue;
            int k = -1, j = -1;
            while (words[i - 1].charAt(++k) == words[i].charAt(++j)) {};
            degree[words[i].charAt(j) - 'a']++;
            graph.get(words[i - 1].charAt(k) - 'a').add(words[i].charAt(j));
        }

        Queue<Character> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (Character ch : set) if (degree[ch - 'a'] == 0) q.add(ch);
        while (!q.isEmpty()) {
            char ch = q.poll();
            set.remove(ch);
            sb.append(ch);
            for (Character c : graph.get(ch - 'a')) {
                degree[c - 'a']--;
                if (degree[c - 'a'] == 0) q.add(c);
            }
        }

        for (int i = 0; i < 26; i++) if (degree[i] != 0) return "";
        for (Character ch : set) sb.append(ch);
        return sb.toString();
    }
}
