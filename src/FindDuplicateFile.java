import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateFile {
    public static List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String path: paths) {
            String[] values = path.split(" ");
//            for (String str : values) {
//                System.out.println(str);
//            }
            for (int i = 1; i < values.length; i++){
                String[] name_cont = values[i].split("\\(");
//                for (String s: name_cont){
//                    System.out.println(s);
//                }
                name_cont[1] = name_cont[1].replace(")","");
                List<String> list = map.getOrDefault(name_cont[1], new ArrayList<>());
                list.add(values[0] + "/" + name_cont[0]);
                map.put(name_cont[1],list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key).size() > 1)
                res.add(map.get(key));
        }
        return res;
    }

    public static void main(String[] args) {
        String[] path = {
                "root/a 1.txt(abcd) 2.txt(efgh)",
                "root/c 3.txt(abcd)",
                "root/c/d 4.txt(efgh)",
                "root 4.txt(efgh)"
        };
        findDuplicate(path);
    }
}
