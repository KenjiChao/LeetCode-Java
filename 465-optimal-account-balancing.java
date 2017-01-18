public class Solution {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> balance = new HashMap<>();
        for (int[] t : transactions) {
            balance.put(t[0], balance.getOrDefault(t[0], 0) - t[2]);
            balance.put(t[1], balance.getOrDefault(t[1], 0) + t[2]);
        }
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        for (Integer val : balance.values()) {
            if (val == 0) continue;
            if (val > 0) pos.add(val);
            else neg.add(-val);
        }
        int transfers = transactions.length;
        Stack<Integer> q_neg = new Stack<>();
        Stack<Integer> q_pos = new Stack<>();
        for (int i = 0; i < 1000; i++) {
            for (int p : pos) q_pos.push(p);
            for (int n : neg) q_neg.push(n);
            int cur = 0;
            while (!q_pos.isEmpty()) {
                int val = q_pos.pop() - q_neg.pop();
                if (val > 0) q_pos.push(val);
                else if (val < 0) q_neg.push(-val);
                cur++;
            }
            transfers = Math.min(transfers, cur);
            Collections.shuffle(pos);
            Collections.shuffle(neg);
        }
        return transfers;
    }
}
