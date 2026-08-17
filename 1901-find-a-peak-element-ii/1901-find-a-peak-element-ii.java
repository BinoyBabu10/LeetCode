class Solution {
    public int[] findPeakGrid(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        int low = 0;
        int high = rows - 1;

        while (low <= high) {

            int midRow = low + (high - low) / 2;

            // Find maximum element in this row
            int maxCol = 0;

            for (int j = 1; j < cols; j++) {
                if (mat[midRow][j] > mat[midRow][maxCol]) {
                    maxCol = j;
                }
            }

            int up = (midRow > 0)
                    ? mat[midRow - 1][maxCol]
                    : -1;

            int down = (midRow < rows - 1)
                    ? mat[midRow + 1][maxCol]
                    : -1;

            // Peak found
            if (mat[midRow][maxCol] > up &&
                mat[midRow][maxCol] > down) {

                return new int[]{midRow, maxCol};
            }

            // Larger neighbor is above
            if (up > mat[midRow][maxCol]) {
                high = midRow - 1;
            }

            // Larger neighbor is below
            else {
                low = midRow + 1;
            }
        }

        return new int[]{-1, -1};
    }
}