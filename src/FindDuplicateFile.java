import jdk.jshell.spi.ExecutionControlProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class FindDuplicateFile {
    public static List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String path: paths) {
            String[] values = path.split(" ");

            for (int i = 1; i < values.length; i++){
                String[] name_cont = values[i].split("\\(");

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

//    public static void main(String[] args) {
//        String[] path = {
//                "root/a 1.txt(abcd) 2.txt(efgh)",
//                "root/c 3.txt(abcd)",
//                "root/c/d 4.txt(efgh)",
//                "root 4.txt(efgh)"
//        };
//        findDuplicate(path);
//    }

    public List<List<String>> findDuplicates(String path) throws Exception {
        List<List<String>> result = new ArrayList<>();
        if(path==null || path.length()==0) return result;

        List<String> filesPath = getAllFiles(path);
        Map<String, List<String>> dupFilesMap = new HashMap<>();

        for(String filePath: filesPath) {
            File file = new File(filePath);
            String hashCode = hashFile(file, "MD5");

            if(!dupFilesMap.containsKey(hashCode)) {
                dupFilesMap.put(hashCode, new ArrayList<>());
            }
            dupFilesMap.get(hashCode).add(filePath);
        }

        for(List<String> dupFiles: dupFilesMap.values()) {
            if(dupFiles.size()>1)
                result.add(dupFiles);
        }

        return result;
    }

    private List<String> getAllFiles(String path) {
        List<String> filesPath = new ArrayList<>();
        Stack<String> s = new Stack<>();
        s.push(path); //DFS with Stack

        while(!s.isEmpty()) {
            String currPath = s.pop();
            File file = new File(currPath);

            if(file.isFile()) {
                filesPath.add(currPath);
            } else if(file.isDirectory()) {
                String[] subDir = file.list();
                for(String dir:subDir) {
                    s.push(currPath+"/"+dir);
                }
            }
        }

        return filesPath;
    }

    private Map<Long, List<String>> getAllFilesBySize(String path) {
        Map<Long, List<String>> fileSizeMap = new HashMap<>();
        Stack<String> s = new Stack<>();
        s.push(path);

        while(!s.isEmpty()) { //DFS by stack
            String currPath = s.pop();
            File file = new File(currPath);

            if(file.isFile()) {
                long size = file.length();
                if(!fileSizeMap.containsKey(size))
                    fileSizeMap.put(size, new ArrayList<>());
                fileSizeMap.get(size).add(currPath);
            } else if(file.isDirectory()) {
                String[] subDir = file.list();
                for(String dir:subDir) {
                    s.push(currPath+"/"+dir);
                }
            }
        }

        return fileSizeMap;
    }

    private static String hashFile(File file, String algorithm)
            throws Exception {
        try (FileInputStream inputStream = new FileInputStream(file)) {
            MessageDigest digest = MessageDigest.getInstance(algorithm);

            byte[] bytesBuffer = new byte[1024];
            int bytesRead = -1;

            while ((bytesRead = inputStream.read(bytesBuffer)) != -1) {
                digest.update(bytesBuffer, 0, bytesRead);
            }

            byte[] hashedBytes = digest.digest();

            return convertByteArrayToHexString(hashedBytes);
        } catch (NoSuchAlgorithmException | IOException ex) {
            throw new Exception(
                    "Could not generate hash from file", ex);
        }
    }
    private static String convertByteArrayToHexString(byte[] arrayBytes) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arrayBytes.length; i++) {
            stringBuffer.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16)
                    .substring(1));
        }
        return stringBuffer.toString();
    }


}
