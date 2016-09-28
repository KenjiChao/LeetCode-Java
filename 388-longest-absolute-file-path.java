public class Solution {
    public int lengthLongestPath(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;
        stack.addFirst(0);
        for (String s : input.split("\n")) {
            int level = s.lastIndexOf("\t") + 1;
            while (level + 1 < stack.size()) stack.removeFirst();
            int len = stack.peekFirst() + s.length() - level + 1;
            stack.addFirst(len);
            if (s.contains(".")) max = Math.max(max, len - 1);
        }
        return max;
    }
}

public class Solution {
    public int lengthLongestPath(String input) {
        String[] names = input.split("\n");
        int[] stack = new int[names.length + 1];
        int max = 0;
        for (String s : names) {
            int level = s.lastIndexOf("\t") + 1;
            int len = stack[level + 1] = stack[level] + s.length() - level + 1;
            if (s.contains(".")) max = Math.max(max, len - 1);
        }
        return max;
    }
}
