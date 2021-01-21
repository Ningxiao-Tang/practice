import java.util.ArrayList;
import java.util.List;

public class textJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();

        int i = 0, n = words.length;
        while (i < n) {
            int j = i + 1;
            int lineLength = words[i].length();
            while (j < n && (lineLength + words[j].length() + (j-i-1) < maxWidth)) {
                lineLength += words[j].length();
                ++j;
            }
            int diff = maxWidth - lineLength;
            int numWords = j - i;
            if (numWords == 1 || j >= n) {
                result.add(leftJustify(words, diff, i, j));
            } else {
                result.add(middleJustify(words, diff, i, j));
            }
            i = j;
        }
        return result;
    }

    private String leftJustify(String[] words, int diff, int i, int j) {
        int spaceOnRight = diff - (j - i -1);
        StringBuilder result = new StringBuilder(words[i]);
        for (int k = i + 1; k < j; k++) {
            result.append(" "+words[k]);
        }
        result.append(" ".repeat(spaceOnRight));
        return result.toString();
    }

    private String middleJustify(String[] words, int diff, int i, int j) {
        int spacesNeeded =  j - i - 1;
        int aveSpaces = diff / spacesNeeded;
        int extraSpace = diff % spacesNeeded;
        StringBuilder result = new StringBuilder(words[i]);
        for (int k = i + 1; k < j; ++k) {
            int spacesToApply = aveSpaces + (extraSpace -- > 0 ? 1 : 0);
            result.append(" ".repeat(spacesToApply) + words[k]);
        }
        return result.toString();
    }
}
