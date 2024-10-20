import java.util.Scanner;

public class Warshall_Transitive_Closure {
  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter the number of vertices: ");
      int vertices = scanner.nextInt();

      int[][] adj = new int[vertices][vertices];

      System.out.println("Enter the adj matrix: ");

      for(int i = 0; i < vertices; i++){
          for(int j = 0; j < vertices; j++){
              adj[i][j] = scanner.nextInt();
          }
      }

      /* O(N^3) -> Time complexity */
      for(int k = 0; k < vertices; k++){
          int[][] temp = new int[vertices][vertices];

          for (int i = 0; i < vertices; i++) {
              for (int j = 0; j < vertices; j++) {
                  temp[i][j] = adj[i][j] | (adj[i][k] & adj[k][j]);
              }
          }

          // Update the original matrix with the temporary matrix
          for (int i = 0; i < vertices; i++) {
              for (int j = 0; j < vertices; j++) {
                  adj[i][j] = temp[i][j];
              }
          }
      }

       System.out.println("The transitive closure is below: ");
      for(int i = 0; i < vertices; i++){
          for(int j = 0; j < vertices; j++){
              System.out.print(adj[i][j] + " ");
          }
          System.out.println();
      }

  }
}