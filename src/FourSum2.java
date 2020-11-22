import java.util.HashMap;
import java.util.Map;

public class FourSum2 {
    //折半搜索，将前一半的搜索结果放到哈希表，再在哈希表里搜索后一半结果的负值
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] = B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] = D[j];
                if (map.containsKey(-sum)) {
                    ans += map.get(-sum);
                }
            }
        }
        return ans;
    }
}
