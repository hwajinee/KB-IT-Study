package week02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS_list {
    public void bfs(List<List<Integer>> graph, int startVertex) {
        // 큐와 visited 배열 준비
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];

        // 시작 노드 예약(예약과 동시에 visited는 true로)
        queue.add(startVertex);
        visited[startVertex] = true;
        
        // 큐가 빌 때까지 반복
        while(!queue.isEmpty()){
            int curVertex = queue.remove();
            for(int nextVertex : graph.get(curVertex)){
                if(!visited[nextVertex]){
                    queue.add(nextVertex);
                    visited[nextVertex] = true;
                }
            }
        }

    }

    public static void main(String[] args) {
        (new BFS_list()).bfs(makeGraph(), 0);
    }

    private static List<List<Integer>> makeGraph() {
        return new ArrayList<>() {{
            add(List.of(1, 3, 6));
            add(List.of(0, 3));
            add(List.of(3));
            add(List.of(0, 1, 2, 7));
            add(List.of(5));
            add(List.of(4, 6, 7));
            add(List.of(0, 5));
            add(List.of(3, 5));

        }};

    }
}
