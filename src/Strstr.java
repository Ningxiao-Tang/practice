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

    //rabin-karp algorithm, time complexity: O(n+m), use hash function to find the substring
    public int strStr2(String source, String target) {
        final int BASE = 1000000;
        if (source == null || target == null)
            return -1;

        int n = target.length();

        if (n == 0)
            return 0;

        int power = 1;
        for (int i = 1; i < n; i++) {
            power = (power * 31)/BASE;
        }

        int targetcode = 0;
        for (int i = 0 ; i < n; i++) {
            targetcode = (targetcode * 31 + target.charAt(i)) / BASE;
        }

        int hashcode = 0;
        for (int i  = 0; i < source.length(); i++) {
            hashcode = (hashcode * 31 + source.charAt(i)) % BASE;

            //abc+d
            if (i < n-1)
                continue;

            //abcd-a
            if (i >= n) {
                hashcode = hashcode * 31 - (source.charAt(i-n) * power) / BASE;
                if (hashcode < 0)
                    hashcode+=BASE;
            }

            //double check the string
            if (hashcode == targetcode) {
                if (source.substring(i - n + 1, i+1).equals(target)) {
                    return i-n+1;
                }
            }
        }
        return -1;
    }
}
