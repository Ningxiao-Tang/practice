import java.util.*;

public class anagram2 {
    public static List<String> anagram(List<String> list) {
        for (int i = 0; i < list.size(); i++) {

            for (int j = i + 1; j < list.size(); j++){
                //int num = 0;
                boolean anagram = true;
                int[] counter = new int[26];
                if (list.get(i).length() != list.get(j).length()) continue;

                for (int k = 0; k <list.get(i).length(); k++) {
                    counter[list.get(i).charAt(k)-'a']++;
                    counter[list.get(j).charAt(k)-'a']--;
                }
                for (int count : counter) {
                    if (count != 0){
                        anagram = false;
                    }
                }
                if (anagram) {
                    //num++;
                    System.out.println("j: "+ j+ ": "+ list.get(j));
                    list.remove(j);
                    j--;
                }
//                if (num == 1){
//
//                }

            }
        }
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        List<String> res = anagram(list);
//        for (String s: anagram(list)){
//            System.out.println(s);
//        }
    }
}
