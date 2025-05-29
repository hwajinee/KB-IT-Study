package week02.prac02;

import java.util.*;

class Solution {
    public static  List<List<Integer>> graph;

    public int solution(int n, int[][] edges) {

        makeAdjList(n, edges);

        return bfs(graph, 1);
    }

    private void makeAdjList(int n, int[][] edges) {
        // 인접 리스트 초기화
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(i, new ArrayList<>()); // 각 노드에 대해 빈 리스트 추가
        }

        // 양방향 간선 추가
        for (int[] edge : edges) {
            int a = edge[0]-1; // edge={3, 6} -> a : index 2번 노드, b = index 5번 노드
            int b = edge[1]-1;

            graph.get(a).add(b); // a -> b 연결
            graph.get(b).add(a); // b -> a 연결 (양방향)
        }
    }

    public int bfs(List<List<Integer>> graph, int startVertex) {
        // 큐와 visited 배열 준비
        Queue<Integer> queue = new LinkedList<>();
        int[][] visited = new int[graph.size()][2]; 
        // [*][] : 방문여부, [][*] : 거리

        // 시작 노드 예약
        int dist = 0;
        int count = 1;
        queue.add(startVertex);
        visited[0][0] = 1;
        visited[0][1] = dist;

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            // 현재 노드 방문
            int curVertex = queue.remove();
            System.out.println(curVertex + "번 노드 방문, 거리: " + dist);
            
            // 다음 노드 예약
            dist += 1;
            count = graph.get(curVertex).size();
            for (int nextVertex : graph.get(curVertex)) {
                if (visited[nextVertex-1][0] == 0) {
                    queue.add(nextVertex);
                    visited[nextVertex-1][0] = 1;
                    visited[nextVertex-1][1] = dist;
                }
            }
        }

        return count;

    }
}