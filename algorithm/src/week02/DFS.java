package week02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DFS {
    public static void main(String[] args) {
        (new DFS()).solve(new ArrayList<>(makeGraph()));
    }

    public static List<List<Integer>> makeGraph() {
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

    public void solve(List<List<Integer>> graph){
        Set<Integer> visited = new HashSet<>();
        dfs(graph, visited, 0);
    }

    public void dfs(List<List<Integer>> graph, Set<Integer> visited, int curVertex){
        visited.add(curVertex);
        System.out.print(curVertex + " ");
        for(int nextVertex : graph.get(curVertex)){
            if(!visited.contains(nextVertex)){
                dfs(graph, visited, nextVertex);
            }
        }
    }

}
