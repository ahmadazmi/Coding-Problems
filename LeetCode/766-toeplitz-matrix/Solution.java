class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int i = 0, j = 0, k = 0, val = matrix[i][j];
        while (k < matrix.length) {
            i = k; j = 0; val = matrix[i][j];
            while (i < matrix.length && j < matrix[i].length)
                if (matrix[i++][j++] != val) return false;
            k++;
        }
        k = 1; i = 0; j = k;
        while (k < matrix[0].length) {
            i = 0; j = k; val = matrix[i][j];
            while (i < matrix.length && j < matrix[i].length)
                if (matrix[i++][j++] != val) return false;
            k++;
        }
        return true;
    }
}