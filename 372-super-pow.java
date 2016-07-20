public class Solution {
    final int MOD = 1337;
    public int superPow(int a, int[] b) {
        if (a % MOD == 0 || b == null || b.length == 0) return 0;
        if (a == 1) return 1;

        a = a % MOD;
        List<Integer> remList = new ArrayList<>();
        int rem = a;
        boolean[] set = new boolean[MOD];
        // find the cycle of a^n mod m
        while (!set[rem]) {
            set[rem] = true;
            remList.add(rem);
            rem = rem * a % MOD;
        }

        int size = remList.size();
        int index = 0;
        // find b[] mod size
        for (int i = 0; i < b.length; i++) {
            index = (index * 10 + b[i]) % size;
        }
        return remList.get(index == 0 ? size - 1 : index - 1);
    }
}
