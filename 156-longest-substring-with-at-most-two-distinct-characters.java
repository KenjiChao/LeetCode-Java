// Can generalize to k distinct characters
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int max = 0;
        Map<Character, Integer> latest = new HashMap<>(); // rightmost index of a given char
        for (int l = 0, h = 0; h < s.length(); h++) {
            latest.put(s.charAt(h), h);
            if (latest.size() > 2) {
                int leftmost = h;
                for (Integer val : latest.values()) {
                    leftmost = Math.min(leftmost, val);
                }
                l = leftmost + 1;
                latest.remove(s.charAt(leftmost));
            }
            max = Math.max(max, h - l + 1);
        }
        return max;
    }
}

// Time: O(n), Space: O(1)
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int max = 0;
        int[] last_pos = new int[2];
        char[] chars = new char[2];
        for (int l = 0, h = 0; h < s.length(); h++) {
            if (h == 0 || chars[0] == s.charAt(h)) {
                last_pos[0] = h;
                chars[0] = s.charAt(h);
            } else if (last_pos[1] == 0 || chars[1] == s.charAt(h)) {
                last_pos[1]= h;
                chars[1] = s.charAt(h);
            } else {
                int idx = last_pos[0] < last_pos[1] ? 0 : 1;
                l = last_pos[idx] + 1;
                last_pos[idx] = h;
                chars[idx] = s.charAt(h);
            }
            max = Math.max(max, h - l + 1);
        }
        return max;
    }
}
