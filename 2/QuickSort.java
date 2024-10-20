
import java.util.Random;

public class QuickSort {
    static int max = 20;
    // Partition method for QuickSort
    int partition(int[] a, int low, int high) {
        int p, i, j, temp;
        p = a[low];
        i = low + 1;
        j = high;
        while (i <= j) {
            while (i <= high && a[i] <= p) {
                i++;
            }
            while (j >= low && a[j] > p) {
                j--;
            }
            if (i < j) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        temp = a[low];
        a[low] = a[j];
        a[j] = temp;
        return j;
    }

    // QuickSort method
    void sort(int[] a, int low, int high) {
        if (low < high) {
            int s = partition(a, low, high);
            sort(a, low, s - 1);
            sort(a, s + 1, high);
        }
    }

    // Generate random array
    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(1000); // Use a larger range for better simulation
        }
        return arr;
    }

    // This is to plot graph : 
     
    public static void main(String[] args) {
        int[] inputSizes = {10, 20, 30, 40, 50, 60}; // Define input sizes
        double[][] executionTimes = new double[inputSizes.length][2];

        for (int i = 0; i < inputSizes.length; i++) {
            int size = inputSizes[i];
            int[] arr = generateRandomArray(size);
            double startTime = System.nanoTime();
            QuickSort m = new QuickSort();
            m.sort(arr, 0, arr.length - 1);
            double stopTime = System.nanoTime();
            double elapseTime = (stopTime - startTime)/ 1e6;

            executionTimes[i][0] = size;
            executionTimes[i][1] = elapseTime;
        }

        // Print the execution times in the required format for JavaScript
        System.out.print("data.addRows([");
        for (int i = 0; i < executionTimes.length; i++) {
            System.out.print("[" + executionTimes[i][0] + ", " + executionTimes[i][1] + "]");
            if (i < executionTimes.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]);");
    }
     
    // public static void main(String[] args) {
    //     int n = 40;  // Hardcoded array size for testing
    //     int[] a = new int[n];  // Adjusted array size to hardcoded input
    
    //     Random r = new Random();
    //     for (int i = 0; i < n; i++) {
    //         a[i] = r.nextInt(1000);
    //     }
    
    //     System.out.println("Array before sorting:");
    //     for (int i = 0; i < n; i++) {
    //         System.out.print(a[i] + " ");
    //     }
    //     System.out.println();
    
    //     double startTime = System.nanoTime();
    //     QuickSort m = new QuickSort();
    //     m.sort(a, 0, n - 1);
    //     double stopTime = System.nanoTime();
    //     double elapseTime = (stopTime - startTime) / 1e6;
    
    //     System.out.println("Time taken to sort array is: " + elapseTime + " ms");
    
    //     System.out.println("Sorted array is:");
    //     for (int i = 0; i < n; i++) {
    //         System.out.print(a[i] + " ");
    //     }
    //     System.out.println();
    // }
    
}
