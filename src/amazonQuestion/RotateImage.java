package amazonQuestion;

public class RotateImage {
  public void rotate(int[][] matrix) {
    int n = matrix.length - 1;
    int temp;

    for (int i = 0; i < matrix.length / 2 ; i++) {
      for (int j = i; j <= matrix.length - i - 2 ; j++) {
        temp = matrix[i][j];
        matrix[i][j] = matrix[n-j][i];
        matrix[n-j][i] = matrix[n-i][n-j];
        matrix[n-i][n-j] = matrix[j][n - i];
        matrix[j][n - i] = temp;
      }
    }
  }
}
