package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class collab {
    public static int findMaxTeam(List<String> team) {
        int n = team.size();
        int[] visited = new int[n];
        int max = 0;
        for (int i = 0; i < n; i ++) {
            if (visited[i] == 0) {
                int cur = dfs(team, i, visited);
                max  = Math.max(max, cur);
            }
        }
        return max;
    }
    private static int dfs(List<String> team, int i, int[] visited) {
        if (visited[i] == 1)
            return 0;
        visited[i] = 1;
        int count = 1;
        for (int j = 0; j < team.size(); j++) {
            if (team.get(i).charAt(j) == '1'){
                count += dfs(team, j, visited);
                System.out.println("i: " +i+" j: "+j+" count: "+ count);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<String> team = new ArrayList<>();
        team.add("1100");
        team.add("1110");
        team.add("0110");
        team.add("0001");
        System.out.println(findMaxTeam(team));
    }
}
