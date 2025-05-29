package week02.prac02;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 6;
        int[][] edges= {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution.solution(n, edges));
    }
}
