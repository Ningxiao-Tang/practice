import java.util.HashMap;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        HashMap<String, Character> map_word  = new HashMap<>();
        HashMap<Character, String> map_char = new HashMap<>();
        String[] word = s.split(" ");
        if (pattern.length() != word.length)
            return false;

        for (int i =0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = word[i];
            if (!map_char.containsKey(c)) {
                if (map_word.containsKey(w))
                    return false;
                else {
                    map_word.put(w,c);
                    map_char.put(c,w);
                }
            } else{
                if (!map_char.get(c).equals(w))
                    return false;
            }
        }
        return true;
    }
}
