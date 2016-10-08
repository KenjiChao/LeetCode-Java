// Recursive
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> cur, int[] nums, int start) {
        res.add(new ArrayList<>(cur));
        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            backtrack(res, cur, nums, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}

// Bit
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int total = (int) Math.pow(2, n);
        List<Integer>[] res = new List[total];
        for (int i = 0; i < total; i++) {
            res[i] = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    res[i].add(nums[j]);
                }
            }
        }
        return Arrays.asList(res);
    }
}

// Iterative
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> element = new ArrayList<>(res.get(j));
                element.add(nums[i]);
                res.add(element);
            }
        }
        return res;
    }
}
