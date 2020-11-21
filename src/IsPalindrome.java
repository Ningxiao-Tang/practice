public class IsPalindrome {
    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        char[] str = s.toCharArray();
        for (char c: str) {
            if (Character.isDigit(c) || Character.isAlphabetic(c))
                sb.append(c);
        }
        String string = sb.toString();
        char [] res = string.toCharArray();

        for (int i = 0; i < res.length; i++) {
            if (res[i]!=res[res.length-i-1]){
                return false;
            }
        }
        return true;
    }

    // faster solution with two pointers
    public static boolean isPalindrome2(String s) {
        if (s == null) {
            return false;
        }
        int left = 0, right = s.length()-1;
        while (left < right) {
            while (left < right && !isValid(s.charAt(left)))
                left++;
            while (left < right && !isValid(s.charAt(right)))
                right--;
            if (left < right && !isEqual(s.charAt(left), s.charAt(right)))
                return false;
            left++; right--;

        }
        return true;
    }

    private static boolean isEqual(char a, char b) {
        return Character.toLowerCase(a) == Character.toLowerCase(b);
    }

    private static boolean isValid(char c) {
        return Character.isAlphabetic(c) || Character.isDigit(c);
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }


}
