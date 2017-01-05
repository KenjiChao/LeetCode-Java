/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */

    private char[] buffer = new char[4];
    private int bufferIndex = 0;
    private int bufferCount = 0;
    public int read(char[] buf, int n) {
        int count = 0;
        while (count < n) {
            if (bufferIndex == 0) bufferCount = read4(buffer);
            if (bufferCount == 0) break;
            for (; count < n && bufferIndex < bufferCount; count++, bufferIndex++) {
                buf[count] = buffer[bufferIndex];
            }
            if (bufferIndex == bufferCount) bufferIndex = 0;
        }
        return count;
    }
}
