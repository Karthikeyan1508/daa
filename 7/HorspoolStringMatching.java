import java.util.Scanner;

public class HorspoolStringMatching {

    public static int[] shiftTable(String pattern) {
        int[] table = new int[256];
        int m = pattern.length();
        
        // In   itialize all positions to pattern length
        for (int i = 0; i < 256; i++) {
            table[i] = m;
        }
        
        // Populate the shift table
        for (int i = 0; i < m - 1; i++) {
            table[pattern.charAt(i)] = m - 1 - i;
        }
        
        return table;
    }

    public static int horspoolSearch(String text, String pattern) {
        int[] table = shiftTable(pattern);
        int n = text.length();
        int m = pattern.length();
        
        int i = m - 1;
        while (i < n) {
            int k = 0;
            while (k < m && pattern.charAt(m - 1 - k) == text.charAt(i - k)) {
                k++;
            }
            if (k == m) {
                return i - m + 1; // Pattern found at index i - m + 1
            } else {
                i += table[text.charAt(i)];
            }
        }
        return -1; // Pattern not found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String text = scanner.nextLine();
        System.out.print("Enter the pattern to search for: ");
        String pattern = scanner.nextLine();
        
        long startTime = System.nanoTime();
        int index = horspoolSearch(text, pattern);
        long endTime = System.nanoTime();
        
        if (index != -1) {
            System.out.println("Pattern found at index: " + index);
        } else {
            System.out.println("Pattern not found.");
        }
        
        double timeElapsed = (endTime - startTime) / 1e6; // Convert nanoseconds to milliseconds
        System.out.println("Time elapsed: " + timeElapsed + " milliseconds");
        
        scanner.close();
    }
}
