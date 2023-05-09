package problems;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{new int[]{1,2,3}, new int[]{4,5,6},new int[]{7,8,9}}));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = m == 0 ? 0 : matrix[0].length;
        List<Integer> list = new ArrayList<>();

        // Edge cases
        if (m == 0 || n == 0) {
            return new ArrayList<>();
        }
        if (m == 1 && n == 1) {
            list.add(matrix[0][0]);
            return list;
        }
        if (m == 1) {
            for (int i = 0; i < n; i++) {
                list.add(matrix[0][i]);
            }
            return list;
        }
        if (n == 1) {
            for (int[] ints : matrix) {
                list.add(ints[0]);
            }
            return list;
        }

        // Top row
        for (int i = 0; i < n; i++) {
            list.add(matrix[0][i]);
        }

        // Right column
        for (int i = 1; i < m; i++) {
            list.add(matrix[i][n - 1]);
        }

        // Bottom row
        for (int i = n - 2; i >= 0; i--) {
            list.add(matrix[m - 1][i]);
        }

        // left column
        for (int i = m - 2; i > 0; i--) {
            list.add(matrix[i][0]);
        }

        // New matrix
        int[][] newMatrix = new int[m - 2][n - 2];

        for (int i = 1; i < m - 1; i++) {
            System.arraycopy(matrix[i], 1, newMatrix[i - 1], 0, n - 1 - 1);
        }

        list.addAll(spiralOrder(newMatrix));

        return list;
    }
}