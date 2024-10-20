import java.util.Scanner;

public class KnapsackDP {

    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];
        
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        
        displayMatrix(dp);
        return dp[n][capacity];
    }

    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of items: ");
        int n = 0;
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        } else {
            System.out.println("Invalid input for the number of items.");
            return;
        }
        
        int[] weights = new int[n];
        int[] values = new int[n];
        
        System.out.println("Enter the weights of the items:");
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                weights[i] = scanner.nextInt();
            } else {
                System.out.println("Invalid input for weight.");
                return;
            }
        }
        
        System.out.println("Enter the values of the items:");
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                values[i] = scanner.nextInt();
            } else {
                System.out.println("Invalid input for value.");
                return;
            }
        }
        
        System.out.print("Enter the knapsack capacity: ");
        int capacity = 0;
        if (scanner.hasNextInt()) {
            capacity = scanner.nextInt();
        } else {
            System.out.println("Invalid input for knapsack capacity.");
            return;
        }
        
        System.out.println("Dynamic Programming Matrix:");
        int maxValue = knapsack(weights, values, capacity);
        System.out.println("Maximum value: " + maxValue);
        
        scanner.close();
    }
}