// O(n) solution
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();
        int m = words.length;
        List<Integer> res = new ArrayList<>();
        if (m == 0) return res;
        int wl = words[0].length();
        Map<String, Integer> histogram = new HashMap<>();
        for (int i = 0; i < m; i++) {
            histogram.putIfAbsent(words[i], 0);
            histogram.put(words[i], histogram.get(words[i]) + 1);
        }

        for (int i = 0; i < wl; i++) {
            int left = i;
            Map<String, Integer> mHistogram = new HashMap<>();
            int count = 0;
            for (int j = i; j <= n - wl; j += wl) {
                String sub = s.substring(j, j + wl);
                if (histogram.containsKey(sub)) {
                    mHistogram.putIfAbsent(sub, 0);
                    mHistogram.put(sub, mHistogram.get(sub) + 1);
                    count++;
                    while (mHistogram.get(sub) > histogram.get(sub)) {
                        String rmSub = s.substring(left, left + wl);
                        mHistogram.put(rmSub, mHistogram.get(rmSub) - 1);
                        count--;
                        left += wl;
                    }
                    if (count == m) {
                        res.add(left);
                    }
                } else {
                    mHistogram.clear();
                    count = 0;
                    left = j + wl;
                }
            }
        }

        return res;
    }
}
