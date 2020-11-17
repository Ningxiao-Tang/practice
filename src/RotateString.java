public class RotateString {
    /**
     * 给出一个字符串(以字符数组形式给出)，一个右偏移和一个左偏移，根据给出的偏移量循环移动字符串。
     * (left offest表示字符串向左的偏移量，right offest表示字符串向右的偏移量，
     * 左偏移量和右偏移量计算得到总偏移量，在总偏移量处分成两段字符串并交换位置)。
     */
    public static String RotateString2(String str, int left, int right) {
        int n = str.length();
        int offset = left-right;
        int r = offset%n;
        StringBuilder sb = new StringBuilder();
        if (r > 0){ // rotate left
            sb.append(str, r, n);
            sb.append(str, 0, r);

        }
        if (r < 0) {// rotate right
            sb.append(str, n+r, n);
            sb.append(str, 0, n+r);
        }
        else if (r == 0)
            sb.append(str);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(RotateString2("abcdefg",3,1));
    }
}
