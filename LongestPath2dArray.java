

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LongestPath2dArray {
    private static Scanner scan;

    public static void main(String[] args) throws FileNotFoundException {
        // Open the file
        File input4 = new File("input4.text");

        scan = new Scanner(input4);

        // m rows, n cols
        int m = 0, n = 0;
        m = scan.nextInt();
        n = scan.nextInt();
        int[][] array = new int[m][n];

        // Store all values into a 2D array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = scan.nextInt();
            }
        }

        // Go through the array and find the Longest Decreasing Path
        int result = 0;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                result = Math.max(result, LDP(array, i, j, m, n));
            }
        }
        System.out.println(result);

        // Close the scanner object
        scan.close();
    }

    // Return the Longest Decreasing Path in 2D array
    // Only move right or down
    static int LDP(int A[][], int i, int j, int m, int n) {
        int answer = 1; // single sequence
        if (j + 1 < n && A[i][j] >= A[i][j + 1])
            answer = Math.max(answer, 1 + LDP(A, i, j + 1, m, n));
        if (i + 1 < m && A[i][j] >= A[i + 1][j])
            answer = Math.max(answer, 1 + LDP(A, i + 1, j, m, n));
        return answer;
    }
}
