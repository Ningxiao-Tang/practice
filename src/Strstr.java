public class Strstr {
    /**
     * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     * @param haystack original string
     * @param needle target substring
     * @return the index where the needle first occur
     */
    public int strStr(String haystack, String needle) {
        // the sequence of the edge case handling is important
        // case"", "" should return 0 instead of -1
        if (needle.length() == 0) return 0;
        if (haystack.length() == 0) return -1;

        for (int i = 0; i < haystack.length(); i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (i+j > haystack.length()) break;
                if (haystack.charAt(i+j) != needle.charAt(j)) break;
                if (j == needle.length()-1) return i;
            }
        }
        return -1;
    }
}
