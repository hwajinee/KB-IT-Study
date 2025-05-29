package week04;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] case1 = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        int[][] case2 = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        int[][] case_err = {{}, {2, 4, 6}, {1, 4, 8, 9}, {7, 8}, {6, 9}, {1, 5, 7, 8, 9}, {3, 6, 9}, {2, 3, 4, 6, 9}, {2, 4, 5, 6, 7, 8}};

        boolean result1 = solution.isBipartite(case1);
        boolean result2 = solution.isBipartite(case2);
        boolean result3 = solution.isBipartite(case_err);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}

class Solution {
    static boolean isBipartite;

    public boolean isBipartite(int[][] graph) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<graph.length; i++){
            adjList.add(i, new ArrayList<>());
        }
        for(int i=0; i<graph.length; i++){
            for(int num : graph[i]){
                adjList.get(i).add(num);
            }
        }

        // dfs 순회
        boolean[] visited = new boolean[graph.length];
        int[] set_num = new int[graph.length]; // 1 또는 2로 두 개 집합 구분
        isBipartite = true;

        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                visited[i] = true;
                set_num[i] = 1;
                dfs(adjList, visited, set_num, i);
            }
        }
        return isBipartite;
    }

    public void dfs(List<List<Integer>> graph, boolean[] visited, int[] set_num, int curVertex) {
        if(!isBipartite) return;
        for(int nextVertex : graph.get(curVertex)){
            if(set_num[curVertex] == set_num[nextVertex]){
                isBipartite = false;
                return;
            }
            if(!visited[nextVertex]) {
                visited[nextVertex] = true;
                set_num[nextVertex] = (set_num[curVertex] % 2) + 1; // 1 <-> 2
                dfs(graph, visited, set_num, nextVertex);
            }
        }
    }
}