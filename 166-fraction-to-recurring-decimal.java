public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();

        // "+" or "-"
        sb.append((numerator > 0) ^ (denominator > 0) ? "-" : "");
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // integral part
        sb.append(num / den);
        num %= den;
        if (num == 0) return sb.toString();

        // fractional part
        Map<Long, Integer> map = new HashMap<>();
        sb.append(".");
        while (num != 0) {
            if (map.containsKey(num)) {
                sb.insert(map.get(num), "(");
                sb.append(")");
                break;
            } else {
                map.put(num, sb.length());
            }
            num *= 10;
            sb.append(num / den);
            num %= den;
        }
        return sb.toString();
    }
}
