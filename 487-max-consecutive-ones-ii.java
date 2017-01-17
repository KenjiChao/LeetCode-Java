// Time: O(n), Space: O(1)
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, zero = 0, k = 1; // flip at most k zero
        for (int l = 0, h = 0; h < nums.length; h++) {
            if (nums[h] == 0) zero++;
            while (zero > k) {
                if (nums[l++] == 0) zero--;
            }
            max = Math.max(max, h - l + 1);
        }
        return max;
    }
}

// Time: O(n), Space: O(n)
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, k = 1; // flip at most k zero
        Queue<Integer> q = new LinkedList<>();
        for (int l = 0, h = 0; h < nums.length; h++) {
            if (nums[h] == 0) q.add(h);
            if (q.size() > k) l = q.poll() + 1;
            max = Math.max(max, h - l + 1);
        }
        return max;
    }
}

// First idea
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, max = 0, flip = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = i - flip;
                flip = i;
            }
        }
        return Math.max(max, count);
    }
}
