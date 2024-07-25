import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.chart.ui.RefineryUtilities;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.util.Random;

public class MergeSortExample extends ApplicationFrame {

    public MergeSortExample(String title) {
        super(title);
        XYSeries series = new XYSeries("MergeSort Time Complexity");

        int[] sizes = {1000, 2000, 4000, 8000, 16000, 32000, 64000}; // Different input sizes
        Random rand = new Random();

        for (int size : sizes) {
            int[] arr = new int[size];

            // generate random numbers
            for (int i = 0; i < arr.length; i++) {
                arr[i] = rand.nextInt(100);
            }

            long startTime = System.nanoTime(); // start time

            mergeSort(arr); // call merge sort

            long endTime = System.nanoTime(); // end time

            long executionTime = endTime - startTime; // execution time

            series.add(size, executionTime / 1000000.0); // Convert to milliseconds
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createXYLineChart(
                "MergeSort Time Complexity",
                "Input Size",
                "Time (ms)",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);
    }

    public static void main(String[] args) {
        MergeSortExample chart = new MergeSortExample("MergeSort Time Complexity");
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }

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
