/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int count = 0;
        while (count < n) {
            int read = read4(buffer);
            read = Math.min(read, n - count);
            for (int i = 0; i < read; i++) {
                buf[count + i] = buffer[i];
            }
            count += read;
            if (read != 4) break;
        }
        return count;
    }
}
