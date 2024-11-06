import java.util.Scanner;

public class Floyd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of vertices: ");
        int n = sc.nextInt();

        int[][] a = new int[n + 1][n + 1];

        System.out.println("Enter the weighted matrix:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    a[i][j] = Math.min(a[i][j], a[i][k] + a[k][j]);
                }
            }
        }

        System.out.println("The shortest path matrix is:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }

        sc.close();
    }
}