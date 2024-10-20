

import java.util.ArrayList;
import java.util.Scanner;

public class SubsetSumDP {
   public static boolean subsetSum(int[] arr, int sum, ArrayList<Integer> subset) {
       int n = arr.length;
       boolean[][] dp = new boolean[n + 1][sum + 1];

       for (int i = 0; i <= n; i++) {
           dp[i][0] = true;
       }

       for (int i = 1; i <= n; i++) {
           for (int j = 1; j <= sum; j++) {
               if (j >= arr[i - 1]) {
                   dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
               } else {
                   dp[i][j] = dp[i - 1][j];
               }
           }
       }

       if (!dp[n][sum]) {
           return false;
       }

       int i = n, j = sum;

       while (i > 0 && j > 0) {
           if (dp[i][j] != dp[i - 1][j]) {
               subset.add(arr[i - 1]);
               j -= arr[i - 1];
           }
           i--;
       }

       return true;
   }

   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       System.out.print("Enter the number of elements: ");
       int n = scanner.nextInt();
       int[] arr = new int[n];

       System.out.println("Enter the elements:");
       for (int i = 0; i < n; i++) {
           arr[i] = scanner.nextInt();
       }

       System.out.print("Enter the target sum: ");
       int sum = scanner.nextInt();
       ArrayList<Integer> subset = new ArrayList<>();

       long startTime = System.nanoTime();
       boolean hasSubsetSum = subsetSum(arr, sum, subset);
       long endTime = System.nanoTime();

       System.out.println("Subset sum exists: " + hasSubsetSum);

       if (hasSubsetSum) {
           System.out.println("Subset contributing to the sum: " + subset);
       }

       double timeElapsed = (endTime - startTime) / 1e6; // Convert nanoseconds to milliseconds
       System.out.println("Time complexity: " + timeElapsed + " milliseconds");
       scanner.close();
   }
}