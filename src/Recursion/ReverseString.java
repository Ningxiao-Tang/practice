package Recursion;

public class ReverseString {
    public void reverseString(char[] s) {
        int i = 0, j = s.length-1;

        reverseHelper(s , i , j);
    }
    private void reverseHelper(char[] s, int i, int j) {
        if (i > j) {
            return;
        }
        char t = s[i];
        s[i] = s[j];
        s[j] = t;
        reverseHelper(s, i+1, j -1);
    }
}
