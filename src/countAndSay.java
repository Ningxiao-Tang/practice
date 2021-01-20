import java.util.HashMap;

public class countAndSay {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String base = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            char ch = base.charAt(0);
            for (int j = 1; j < base.length(); j++){
                if (base.charAt(j) != ch) {
                    sb.append(count).append(ch);
                    count = 1;
                    ch = base.charAt(j);
                } else {
                    count++;
                }
            }
            sb.append(count).append(ch);
            base = sb.toString();
        }
        return base;
    }
}
