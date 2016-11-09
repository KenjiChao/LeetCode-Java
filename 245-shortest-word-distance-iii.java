public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int i1 = -1, i2 = -1;
        int min = words.length;
        boolean sameWord = word1.equals(word2);
        for (int i = 0; i < words.length; i++) {
            if (sameWord) {
                if (words[i].equals(word1)) {
                    if (i1 != -1) min = Math.min(min, i - i1);
                    i1 = i;
                }
            } else {
                if (words[i].equals(word1)) i1 = i;
                else if (words[i].equals(word2)) i2 = i;
                if (i1 != -1 && i2 != -1) min = Math.min(min, Math.abs(i1 - i2));
            }
        }
        return min;
    }
}
