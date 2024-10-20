import java.util.Random;

public class MergeSort {

    public static void main(String[] args) {
        int[] inputSizes = {10, 20, 30, 40, 50, 60}; // Define input sizes
        double[][] executionTimes = new double[inputSizes.length][2];

        for (int i = 0; i < inputSizes.length; i++) {
            int size = inputSizes[i];
            int[] arr = generateRandomArray(size);

            double startTime = System.nanoTime(); // Start time

            mergeSort(arr); // Call merge sort

            double endTime = System.nanoTime(); // End time

            double executionTime = (endTime - startTime) / 1e6; // Convert to milliseconds

            executionTimes[i][0] = size;
            executionTimes[i][1] = executionTime;
        }

        // Print the execution times in the required format for JavaScript
        System.out.print("data.addRows([");
        for (int i = 0; i < executionTimes.length; i++) {
            System.out.print("[" + (int)executionTimes[i][0] + ", " + executionTimes[i][1] + "]");
            if (i < executionTimes.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]);");
    }

    // Generate a random array of given size
    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(1000); // Random numbers between 0 and 999
        }
        return arr;
    }

    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        // Split array into left and right halves
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        // Recursive calls
        mergeSort(left);
        mergeSort(right);

        // Merge sorted arrays
        merge(left, right, arr);
    }

    public static void merge(int[] left, int[] right, int[] arr) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // Copy remaining elements of left array
        while (i < left.length) {
            arr[k++] = left[i++];
        }

        // Copy remaining elements of right array
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}
