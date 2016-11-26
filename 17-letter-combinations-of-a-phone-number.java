public class Solution {
    final String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        LinkedList<String> q = new LinkedList<>();
        if (digits.length() == 0) return q;
        q.add("");
        for (char ch : digits.toCharArray()) {
            int index = ch - '0';
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String s = q.poll();
                for (char t : mapping[index].toCharArray()) {
                    q.add(s + t);
                }
            }
        }
        return q;
    }
}
