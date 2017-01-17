// clever solution
// 1. Every seq in seqs must be a subsequent of org
// 2. Every consecutive elements in org must appear at least once in seqs
public class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        int n = org.length;
        int[] idx = new int[n + 1];
        Set<String> pairs = new HashSet<>();
        for (int i = 0; i < n; i++) idx[org[i]] = i;
        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size(); i++) {
                if (seq.get(i) < 1 || seq.get(i) > n) return false;
                if (i > 0 && idx[seq.get(i - 1)] >= idx[seq.get(i)]) return false;
                pairs.add((i > 0 ? seq.get(i - 1) : "") + ":" + seq.get(i));
            }
        }
        for (int i = 0; i < org.length; i++) {
            if (!pairs.contains((i > 0 ? org[i - 1] : "") + ":" + org[i])) return false;
        }
        return true;
    }
}

// Topological sort
public class Solution {
    private static final int MAX = 10000;
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int max = 0;
        int[] inward = new int[MAX + 1];
        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size(); i++) {
                if (seq.get(i) < 1 || seq.get(i) > MAX) return false;
                max = Math.max(max, seq.get(i));
                if (i > 0) {
                    inward[seq.get(i)]++;
                    map.putIfAbsent(seq.get(i - 1), new ArrayList<>());
                    map.get(seq.get(i - 1)).add(seq.get(i));
                }
            }
        }
        for (int i = 1; i <= max; i++) {
            if (inward[i] == 0) {
                if (!q.isEmpty()) return false;
                q.add(i);
            }
            map.putIfAbsent(i, new ArrayList<>());
        }

        int idx = 0;
        while (!q.isEmpty()) {
            int val = q.poll();
            if (idx == org.length || org[idx++] != val) return false;
            for (Integer child : map.get(val)) {
                if (--inward[child] == 0) {
                    if (!q.isEmpty()) return false;
                    q.add(child);
                }
            }
        }
        return idx == org.length && idx == max;
    }
}
