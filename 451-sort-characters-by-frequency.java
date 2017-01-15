public class Solution {
    public String frequencySort(String s) {
        int[] histogram = new int[256];
        for (char ch : s.toCharArray()) histogram[ch]++;
        Map<Integer, List<Character>> map = new HashMap<>();
        for (int i = 0; i < histogram.length; i++) {
            if (histogram[i] > 0) {
                if (!map.containsKey(histogram[i])) map.put(histogram[i], new ArrayList<>());
                map.get(histogram[i]).add((char) i);
            }
        }

        StringBuilder sb = new StringBuilder();
        int key = s.length();
        while (sb.length() < s.length()) {
            if (map.containsKey(key)) {
                for (char ch : map.get(key)) {
                    for (int i = 0; i < key; i++) sb.append(ch);
                }
            }
            key--;
        }
        return sb.toString();
    }
}
