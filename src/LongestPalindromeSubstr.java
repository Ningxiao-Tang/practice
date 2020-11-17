public class LongestPalindromeSubstr {
    //expand from center solution
    public String longestPalindrome(String s) {
        int best_len = 0;
        String best_s = "";
        int n = s.length();
        for (int mid = 0; mid < n; mid++) {
            for (int x = 0; mid-x>=0 && mid+x<n; x++) {
                if (s.charAt(mid-x) != s.charAt(mid+x))
                    break;
                int len = 2*x+1;
                if (len > best_len) {
                    best_len = len;
                    best_s = s.substring(mid-x,mid+x+1);
                }
            }
        }

        for (int mid = 0; mid < n-1; mid++) {
            for (int x = 0; mid-x+1>=0 && mid+x<n; x++) {
                if (s.charAt(mid-x+1) != s.charAt(mid+x))
                    break;
                int len = 2*x;
                if (len > best_len) {
                    best_len = len;
                    best_s = s.substring(mid-x+1,mid+x+1);
                }
            }
        }
        return best_s;
    }

    //dynamic programming solution, a lot slower than the above solution
    public String longestPalindrome2(String s) {
        if (s == null || s.equals(""))
            return "";
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        int best_len = 1, start = 0;
        // each character itself is a palindrome
        for (int i = 0; i < n; i++)
            isPalindrome[i][i] = true;

        for (int i = 0; i < n - 1; i++) {
            isPalindrome[i][i+1] = s.charAt(i) == s.charAt(i+1);
            if (isPalindrome[i][i+1]) {
                best_len = 2;
                start = i;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                isPalindrome[i][j] = s.charAt(i) == s.charAt(j) && isPalindrome[i+1][j-1];
                if (isPalindrome[i][j] && j - i + 1 > best_len) {
                    best_len = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start+best_len);
    }
}
