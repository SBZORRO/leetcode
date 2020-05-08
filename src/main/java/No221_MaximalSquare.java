public class No221_MaximalSquare {
//Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
//
//Example:
//
//Input: 
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//Output: 4

  public static void main(String[] args) {
    No221_MaximalSquare test = new No221_MaximalSquare();
    System.out.println(
        test.maximalSquare(
            new char[][] {
                { '1' } }));
    System.out.println(
        test.maximalSquare(
            new char[][] {
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' } }));

    System.out.println(
        test.maximalSquare(
            new char[][] {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '1', '1', '1', '0' } }));

    System.out.println(
        test.maximalSquare(
            new char[][] {
                { '1', '0', '1', '0' },
                { '1', '0', '1', '1' },
                { '1', '0', '1', '1' },
                { '1', '1', '1', '1' } }));

    System.out.println(
        test.maximalSquare(
            new char[][] { { '1', '0', '1', '0', '0', '1', '1', '1', '0' },
                { '1', '1', '1', '0', '0', '0', '0', '0', '1' },
                { '0', '0', '1', '1', '0', '0', '0', '1', '1' },
                { '0', '1', '1', '0', '0', '1', '0', '0', '1' },
                { '1', '1', '0', '1', '1', '0', '0', '1', '0' },
                { '0', '1', '1', '1', '1', '1', '1', '0', '1' },

                { '1', '0', '1', '1', '1', '0', '0', '1', '0' },

                { '1', '1', '1', '0', '1', '0', '0', '0', '1' },
                { '0', '1', '1', '1', '1', '0', '0', '1', '0' },
                { '1', '0', '0', '1', '1', '1', '0', '0', '0' } }));
  }

  public int maximalSquare(char[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    int max = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        matrix[i][j] = (char) (matrix[i][j] - '0');
      }
    }
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 1 && i - 1 >= 0 && j - 1 >= 0) {
          int m = matrix[i - 1][j];
          int n = matrix[i][j - 1];
          int k = matrix[i - 1][j - 1];
          matrix[i][j] = (char) (Math.min(k, Math.min(m, n)) + 1);
          if (m == n) {
            max = Math.max(max, matrix[i][j]);
          }
        } else if (matrix[i][j] == 1 && max == 0) {
          max = 1;
        }
      }
    }
    return max * max;
  }

  public int maximalSquare1(char[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    int max = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        matrix[i][j] = (char) (matrix[i][j] - '0');
      }
    }
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 1) {
          for (int t = 0; i + t < matrix.length
              && j + t < matrix[0].length
              && spread(matrix, i, j, t); t++) {
            max = Math.max(max, (t + 1) * (t + 1));
          }
        }
      }
    }
    return max;
  }

  public boolean spread(char[][] matrix, int i, int j, int t) {
    for (int m = i; m <= i + t && m < matrix.length; m++) {
      if (matrix[m][j + t] == 0) {
        return false;
      }
    }
    for (int m = j; m <= j + t && m < matrix[0].length; m++) {
      if (matrix[i + t][m] == 0) {
        return false;
      }
    }
    return true;
  }
}
