import java.util.Random;

public class QuickSort {

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
            arr[i] = rand.nextInt(10000); // Use a larger range for better simulation
        }
        return arr;
    }

    // Main method
    public static void main(String[] args) {
        int[] inputSizes = {500, 1000, 1500, 2000, 2500, 3000, 3500, 4000, 4500}; // Define input sizes
        long[][] executionTimes = new long[inputSizes.length][2];

        for (int i = 0; i < inputSizes.length; i++) {
            int size = inputSizes[i];
            int[] arr = generateRandomArray(size);
            long startTime = System.nanoTime();
            QuickSort m = new QuickSort();
            m.sort(arr, 0, arr.length - 1);
            long stopTime = System.nanoTime();
            long elapseTime = stopTime - startTime;

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
}
