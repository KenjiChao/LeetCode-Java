public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        if (n == 0) return 0;
        int[] bucket = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations[i] > n) bucket[n]++;
            else bucket[citations[i]]++;
        }
        int count = 0;
        for (int h = n; h >= 0; h--) {
            count += bucket[h];
            if (count >= h) return h;
        }
        return 0;
    }
}
