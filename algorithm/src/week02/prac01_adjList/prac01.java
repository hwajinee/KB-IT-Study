package week02.prac01_adjList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class prac01 {

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        Solution solution = new Solution();
        System.out.println(solution.solution(n, computers));
    }
}

class Solution {
    private static int count = 0;

    public int solution(int n, int[][] computers) {
        // 인접 행렬 computers -> 인접 리스트 adjList로 변환
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i <n; i++) {
            graph.put(i, new ArrayList<>());
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1 && i != j) {
                    // i != j 를 추가해야, 연결된 노드 리스트에 자기 자신이 들어가지 않게 됨.
                    graph.get(i).add(j);
                }
            }
        }

//        // 인접 리스트 잘 저장되었는지 확인
//        for(int i=0; i<n; i++){
//            for(int j : graph.get(i)){
//                System.out.println(i + "번 노드와 연결된 노드 : " + j);
//            }
//        }
        
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(!visited[i]) {
                dfs(graph, visited, i);
                count ++; // 탐색을 한 번 할 때마다 네트워크 갯수 1씩 증가
            }
        }
        return count;
    }

    public void dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int curVertex){
        visited[curVertex] = true;
        /* 시작 노드로부터 연결된 노드를 찾고
           그 중 방문한 적이 없는 노드들에 DFS를 위임.
       */
        for(int nextVertex : graph.get(curVertex)){
            if(!visited[nextVertex]) {
                dfs(graph, visited, nextVertex);
            }
        }
    }
}

