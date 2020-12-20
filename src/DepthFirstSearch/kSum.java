package DepthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class kSum {
    public List<List<Integer>> kSum(int[] A, int k, int target) {
        // write your code here
        Arrays.sort(A);
        List<List<Integer>> subsets = new ArrayList<>();
        dfs(A, 0, k, target, new ArrayList<Integer>(), subsets);
        return subsets;
    }

    public void dfs(int[] A, int cur, int k, int target, List<Integer> path, List<List<Integer>> subsets) {
        if (target == 0 && k == 0) {
            subsets.add(new ArrayList<Integer>(path));
            return;
        }
        if(k == 0 || target <= 0) {
            return;
        }
        for (int i = cur; i < A.length; i++) {
            path.add(A[i]);
            dfs(A, i + 1, k - 1, target - A[i], path, subsets);
            path.remove(path.size() - 1);
        }
    }
}
