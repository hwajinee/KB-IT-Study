package week02.prac03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int solution(int n, int[][] edges) {

        // edge -> 인접 리스트 변환
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(i, new ArrayList<>());
        }

        for(int[] edge : edges){
            int a = edge[0]-1;
            int b = edge[1]-1;

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // bfs 구현
        // queue에 예약할 때 노드 번호와 함께, 방문거리 저장 !!!
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];
        int distance = 0;
        int count = 1;

        // 첫번째 방문 노드 예약
        queue.add(new int[]{0, distance});
        visited[0] = true;

        while(!queue.isEmpty()){
            int[] curVertex = queue.remove();
//            System.out.println("curVertex의 distance: " + curVertex[1]);
            if(distance == curVertex[1]){
                count++;
            } else {
                distance = curVertex[1];
                count = 1;
            }
            // 다음 노드 예약
            for(int nextVertex : graph.get(curVertex[0])){
                if(!visited[nextVertex]){
                    queue.add(new int[]{nextVertex, curVertex[1]+1});
                    visited[nextVertex] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        Solution solution = new Solution();
        System.out.println(solution.solution(n, vertex));
    }
}
