public class No542_01Matrix {
//  Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
//
//  The distance between two adjacent cells is 1.
//
//   
//
//  Example 1:
//
//  Input:
//  [[0,0,0],
//   [0,1,0],
//   [0,0,0]]
//
//  Output:
//  [[0,0,0],
//   [0,1,0],
//   [0,0,0]]
//
//  Example 2:
//
//  Input:
//  [[0,0,0],
//   [0,1,0],
//   [1,1,1]]
//
//  Output:
//  [[0,0,0],
//   [0,1,0],
//   [1,2,1]]
//
//   
//
//  Note:
//
//      The number of elements of the given matrix will not exceed 10,000.
//      There are at least one 0 in the given matrix.
//      The cells are adjacent in only four directions: up, down, left and right.
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/01-matrix
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No542_01Matrix test = new No542_01Matrix();
    System.out.println(test.updateMatrix(new int[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 0 } }));
    System.out.println(test.updateMatrix(new int[][] { { 0, 1, 1 }, { 0, 1, 1 }, { 0, 0, 0 } }));
    System.out.println(test.updateMatrix(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } }));
    System.out.println(test.updateMatrix(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } }));
//    System.out.println(
//        test.updateMatrix(
//            new int[][] {
//                { 1, 1, 0, 0, 1, 0, 0, 1, 1, 0 },
//                { 1, 0, 0, 1, 0, 1, 1, 1, 1, 1 },
//                { 1, 1, 1, 0, 0, 1, 1, 1, 1, 0 },
//                { 0, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
//                { 0, 0, 1, 1, 1, 1, 1, 1, 1, 0 },
//                { 1, 1, 1, 1, 1, 1, 0, 1, 1, 1 },
//                { 0, 1, 1, 1, 1, 1, 1, 0, 0, 1 },
//                { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
//                { 0, 1, 0, 1, 1, 0, 1, 1, 1, 1 },
//                { 1, 1, 1, 0, 1, 0, 1, 1, 1, 1 } }));

//    System.out.println(
//        test.updateMatrix(
//            new int[][] {
//                { 1, 0, 1, 1, 0, 0, 1, 0, 0, 1 },
//                { 0, 1, 1, 0, 1, 0, 1, 0, 1, 1 },
//                { 0, 0, 1, 0, 1, 0, 0, 1, 0, 0 },
//                { 1, 0, 1, 0, 1, 1, 1, 1, 1, 1 },
//                { 0, 1, 0, 1, 1, 0, 0, 0, 0, 1 },
//                { 0, 0, 1, 0, 1, 1, 1, 0, 1, 0 },
//                { 0, 1, 0, 1, 0, 1, 0, 0, 1, 1 },
//                { 1, 0, 0, 0, 1, 1, 1, 1, 0, 1 },
//                { 1, 1, 1, 1, 1, 1, 1, 0, 1, 0 },
//                { 1, 1, 1, 1, 0, 1, 0, 0, 1, 1 }
//            }));

//    System.out.println(test.updateMatrix(new int[][] { { 1 }, { 1 }, { 1 }, { 1 }, { 1 }, { 0 } }));
  }

  int lenX;
  int lenY;

  public int[][] updateMatrix(int[][] matrix) {
    lenX = matrix.length;
    lenY = matrix[0].length;
    for (int i = 0; i < lenX; i++) {
      for (int j = 0; j < lenY; j++) {
        if (matrix[i][j] != 0) {
          matrix[i][j] = findZero(matrix, i, j);
        }
      }
    }
    return matrix;
  }

  public int findZero(int[][] matrix, int x, int y) {
    int result = 0;
    int curX = x;
    int curY = y;
    while (true) {
      result++;
      int c = result;
      int i = 0;
      //p1 left
      curX--;
      for (i = 0; i < c; i++) {
        curX++;
        curY--;
        if (curX >= 0 && curX < lenX && curY >= 0 && curY < lenY) {
          if (matrix[curX][curY] == 0) {
            return result;
          }
        }
      }
      for (i = 0; i < c; i++) {
        curX++;
        curY++;
        if (curX >= 0 && curX < lenX && curY >= 0 && curY < lenY) {
          if (matrix[curX][curY] == 0) {
            return result;
          }
        }
      }
      for (i = 0; i < c; i++) {
        curX--;
        curY++;
        if (curX >= 0 && curX < lenX && curY >= 0 && curY < lenY) {
          if (matrix[curX][curY] == 0) {
            return result;
          }
        }
      }
      for (i = 0; i < c; i++) {
        curX--;
        curY--;
        if (curX >= 0 && curX < lenX && curY >= 0 && curY < lenY) {
          if (matrix[curX][curY] == 0) {
            return result;
          }
        }
      }
    }
  }

  public int[][] updateMatrix1(int[][] matrix) {
    int layer = 0;
    int changes = 1;
    while (changes != 0) {
      changes = 0;
      for (int i = 0; i < matrix.length; i++) {
        int top = i - 1;
        int bot = i + 1;
        for (int j = 0; j < matrix[0].length; j++) {
          if (matrix[i][j] <= layer) {
            continue;
          }
          int prev = j - 1;
          int next = j + 1;

          if (top >= 0) {
            if (matrix[top][j] <= layer) {
              continue;
            }
          }
          if (prev >= 0) {
            if (matrix[i][prev] <= layer) {
              continue;
            }
          }
          if (bot < matrix.length) {
            if (matrix[bot][j] <= layer) {
              continue;
            }
          }
          if (next < matrix[0].length) {
            if (matrix[i][next] <= layer) {
              continue;
            }
          }
          changes++;
          matrix[i][j]++;
        }
      }
      layer++;
    }
    return matrix;
  }
}
