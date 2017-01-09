// 12ms O(m + n) optimized version. m: length of sentence by char, n: rows
public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String str = String.join(" ", sentence) + " ";
        int start = 0, len = str.length();
        int[] map = new int[len];
        for (int i = 1; i < len; i++) {
            map[i] = str.charAt(i) == ' ' ? 1 : map[i - 1] - 1;
        }
        for (int i = 0; i < rows; i++) {
            start += cols;
            start += map[start % len];
        }
        return start / len;
    }
}

// 21ms Original idea
public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String str = String.join(" ", sentence) + " ";
        int start = 0, len = str.length();
        for (int i = 0; i < rows; i++) {
            start += cols;
            if (str.charAt(start % len) == ' ') {
                start++;
            } else {
                while (start > 0 && str.charAt((start - 1) % len) != ' ') start--;
            }
        }
        return start / len;
    }
}
