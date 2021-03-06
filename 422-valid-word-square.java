public class Solution {
    public boolean validWordSquare(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            for (int j = 0; j < word.length(); j++) {
                if (j >= words.size() || i >= words.get(j).length() || word.charAt(j) != words.get(j).charAt(i)) return false;
            }
        }
        return true;
    }
}
