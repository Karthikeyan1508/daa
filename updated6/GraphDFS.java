import java.util.Scanner;

public class GraphDFS { 
    private int vertices;
    private int[][] adjacencyMatrix;

    public GraphDFS(int v) {
        vertices = v;
        adjacencyMatrix = new int[v][v];
    }

    public void addEdge(int start, int end) { 
        adjacencyMatrix[start][end] = 1;
        adjacencyMatrix[end][start] = 1;
    }

    public void dfs(int startVertex, boolean[] visited) { 
        System.out.print(startVertex + " ");
        visited[startVertex] = true;

        for (int i = 0; i < vertices; i++) {
            if (adjacencyMatrix[startVertex][i] == 1 && !visited[i]) {
                dfs(i, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int v = scanner.nextInt();

        GraphDFS graph = new GraphDFS(v);

        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                graph.adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }

        System.out.print("Enter the starting vertex for DFS: ");
        int startVertex = scanner.nextInt();

        boolean[] visited = new boolean[v];
        System.out.print("DFS traversal starting from vertex " + startVertex + ": ");
        graph.dfs(startVertex, visited);

        scanner.close();
    }
}