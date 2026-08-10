import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right across the top row
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++; // Move top boundary down

            // Traverse from top to bottom down the right column
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--; // Move right boundary left

            // Traverse from right to left across the bottom row (if row exists)
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
                bottom--; // Move bottom boundary up
            }

            // Traverse from bottom to top up the left column (if column exists)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++; // Move left boundary right
            }
        }

        return result;
    }
}