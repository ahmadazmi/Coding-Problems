import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralList = new ArrayList<Integer>();
        int i = 0, j = 0, k = 0;
        while (2*k < matrix.length && 2*k < matrix[j].length) {
            // starting position
            i = k; j = k;
            // left to right
            while (i < matrix[j].length - k)
                spiralList.add(matrix[j][i++]);
            int prevRow = j;
            i--; j++;
            // top to bottom
            while (j < matrix.length - k)
                spiralList.add(matrix[j++][i]);
            int prevCol = i;
            j--; i--;
            if (prevRow == j) break;
            // right to left
            while (i >= k)
                spiralList.add(matrix[j][i--]);
            i++; j--;
            if (prevCol == i) break;
            // bottom to top
            while (j > k)
                spiralList.add(matrix[j--][i]);
            k++;
        }
        return spiralList;
    }
}