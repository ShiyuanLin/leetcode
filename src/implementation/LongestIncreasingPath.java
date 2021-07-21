package implementation;

public class LongestIncreasingPath {
  int longestPath;
  int maxRow;
  int maxCol;
  public int solution(int[][] matrix) {
    longestPath = 0;
    maxRow = matrix.length;
    maxCol = matrix[0].length;
    for (int row = 0; row < maxRow; row++) {
      for (int col = 0; col < maxCol; col++) {
        explorerPath(row, col, 1, matrix);
      }
    }
    return longestPath;
  }

  public void explorerPath(int row, int col, int currPath, int[][] matrix) {
    longestPath = Math.max(longestPath, currPath);
    int[] directRows = new int[] {-1, 0, 0, 1};
    int[] directCols = new int[] {0, -1, 1, 0};
    for (int i = 0; i < directRows.length; i++) {
      int nextRow = row + directRows[i];
      int nextCol = col + directCols[i];
      if (nextRow >= 0 && nextRow < maxRow &&
          nextCol >= 0 && nextCol < maxCol && matrix[row][col] < matrix[nextRow][nextCol]) {
        explorerPath(nextRow, nextCol, currPath+1, matrix);
      }
    }
  }
}

//9 9 4
//6 6 8
//2 1 1
