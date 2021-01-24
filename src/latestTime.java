public class latestTime {
    public static String maximumTime(String time) {
        StringBuilder sb = new StringBuilder(time);
        int i;
        while ((i = sb.toString().indexOf('?')) != -1) {
            switch (i) {
                case 0:
                    if (time.charAt(1) == '?')
                        sb.setCharAt(0, '2');
                    else if (time.charAt(1) - '0' < 4)
                        sb.setCharAt(0, '2');
                    else
                        sb.setCharAt(0, '1');
                    break;
                case 1:
                    if (time.charAt(0)- '0' <= 1)
                        sb.setCharAt(1, '9');
                    else
                        sb.setCharAt(1, '3');
                    break;
                case 3:
                    sb.setCharAt(3, '5');
                    break;
                case 4:
                    sb.setCharAt(4, '9');
                    break;
                default:

            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String time = "2?:?0";
        System.out.println(maximumTime(time));


    }
}
