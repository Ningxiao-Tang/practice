package DepthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> path = new ArrayList<Integer>();
        dfs(candidates, 0, target, path, results);
        return results;
    }

    private void dfs(int[] candidates, int cur, int target, List<Integer> path, List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<>(path));
            return;
        }
        if (target < 0)
            return;
        for (int i = cur; i < candidates.length; i++) {
            if (i < cur && candidates[i] == candidates[i-1]) continue;
            path.add(path.size(), candidates[i]);
            dfs(candidates, i + 1, target - candidates[i], path, results);
            path.remove(path.size() - 1);
        }
    }

}
