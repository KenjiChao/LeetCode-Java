public class Solution {
    public boolean isStrobogrammatic(String num) {
        StringBuilder sb = new StringBuilder();
        for (char ch : num.toCharArray()) {
            if (ch == '0' || ch == '1' || ch == '8') sb.append(ch);
            else if (ch == '6') sb.append('9');
            else if (ch == '9') sb.append('6');
            else return false;
        }
        return sb.reverse().toString().equals(num);
    }
}

// two pointer solution
public class Solution {
    public boolean isStrobogrammatic(String num) {
        for (int i = 0, j = num.length() - 1; i <= j; i++, j--) {
            if (!"00 11 88 696".contains(num.charAt(i) + "" + num.charAt(j))) return false;
        }
        return true;
    }
}
