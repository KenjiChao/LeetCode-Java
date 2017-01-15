// bit manipulation
public class Solution {
    public char findTheDifference(String s, String t) {
        int n = t.length();
        char ch = t.charAt(n - 1);
        for (int i = 0; i < n - 1; i++) {
            ch ^= s.charAt(i);
            ch ^= t.charAt(i);
        }
        return ch;
    }
}

// histogram
public class Solution {
    public char findTheDifference(String s, String t) {
        int[] histogram = new int[256];
        for (int i = 0; i < t.length(); i++) {
            if (i != t.length() - 1) histogram[s.charAt(i)]--;
            histogram[t.charAt(i)]++;
        }
        for (int i = 0; i < histogram.length; i++) {
            if (histogram[i] != 0) return (char) i;
        }
        return '\u0000';
    }
}
