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

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }


}
