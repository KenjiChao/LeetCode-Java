public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // mapping hashcode of histogram to index of the return list
        Map<Integer, Integer> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String str : strs) {
            int[] histogram = new int[26];
            for (char ch : str.toCharArray()) {
                histogram[ch - 'a']++;
            }
            int hash = Arrays.hashCode(histogram);
            if (!map.containsKey(hash)) {
                map.put(hash, res.size());
                res.add(new ArrayList<>());
            }
            res.get(map.get(hash)).add(str);
        }
        return res;
    }
}
