class Solution {
    public int maximalSquare(char[][] matrix) {
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j]-'0' == 0) continue;
                res = Math.max(res, 1);
                if (i < 1 || j < 1) continue;
                int square = Math.min(matrix[i-1][j-1], Math.min(matrix[i-1][j], matrix[i][j-1]))-'0';
                if (square == 0) continue;
                matrix[i][j] = (char)(square+1+'0');
                res = Math.max(res, matrix[i][j]-'0');
            }
        }
        return res*res;
    }
}