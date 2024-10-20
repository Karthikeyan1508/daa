
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSDirectedGraph {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        int[][] adjacencyMatrix = new int[vertices][vertices];
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }
        System.out.print("Enter the starting vertex: ");
        int startVertex = scanner.nextInt();
        System.out.println("BFS traversal starting from vertex " + startVertex + ":");
        bfs(adjacencyMatrix, startVertex, vertices);
        scanner.close();
    }

    private static void bfs(int[][] adjacencyMatrix, int startVertex, int vertices) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[startVertex] = true;
        queue.add(startVertex);
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");
            for (int i = 0; i < vertices; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
