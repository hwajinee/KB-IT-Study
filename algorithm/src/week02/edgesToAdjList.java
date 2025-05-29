package week02;

import java.util.ArrayList;
import java.util.List;

public class edgesToAdjList {
    public List<List<Integer>> makeAdjList(int[][] edges, int n){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(i,new ArrayList<>());
        }

        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];

            // 양방향 연결
            graph.get(a).add(b);
            graph.get(b).add(a);
        }


        return graph;
    }
}
