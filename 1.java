import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MergeSortExample {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[1000]; // array to sort

        // generate random numbers
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
        }

        long startTime = System.nanoTime(); // start time

        mergeSort(arr); // call merge sort

        long endTime = System.nanoTime(); // end time

        long executionTime = endTime - startTime; // execution time

        System.out.println("Execution time: " + executionTime + " ns");

        // print sorted array
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
    // This is to plot graph : 
    /* 
    public static void main(String[] args) {
        int[] inputSizes = {500, 1000, 1500, 2000, 2500, 3000, 3500, 4000, 4500}; // define your input sizes
        long[][] executionTimes = new long[inputSizes.length][2];

        for (int i = 0; i < inputSizes.length; i++) {
            int size = inputSizes[i];
            int[] arr = generateRandomArray(size);

            long startTime = System.nanoTime(); // start time

            mergeSort(arr); // call merge sort

            long endTime = System.nanoTime(); // end time

            long executionTime = endTime - startTime; // execution time

            executionTimes[i][0] = size;
            executionTimes[i][1] = executionTime;
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
    */
    
    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        // split array
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < arr.length; i++) {
            right[i - mid] = arr[i];
        }

        // recursive calls
        mergeSort(left);
        mergeSort(right);

        // merge sorted arrays
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

        // copy remaining elements
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}

