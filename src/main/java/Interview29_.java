public class Interview29_ {
//  输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
//
//  
//
//  示例 1：
//
//  输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//  输出：[1,2,3,6,9,8,7,4,5]
//
//  示例 2：
//
//  输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//  输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//
//   
//
//  限制：
//
//      0 <= matrix.length <= 100
//      0 <= matrix[i].length <= 100
//
//  注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    Interview29_ test = new Interview29_();
//    test.spiralOrder(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });
//    test.spiralOrder(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } });
//    test.spiralOrder(new int[][] { { 6, 9, 7 } });
    test.spiralOrder(new int[][] { { 3 }, { 2 } });
  }

  public int[] spiralOrder(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return new int[0];
    }
    int[] res = new int[matrix.length * matrix[0].length];
    int indi = 0;
    for (int t = 0; t < (Math.min(matrix.length, matrix[0].length) + 1) / 2; t++) {
      for (int i = t; i < matrix[0].length - t && indi < res.length; i++, indi++) {
        res[indi] = matrix[t][i];
      }
      for (int i = t + 1; i < matrix.length - 1 - t && indi < res.length; i++, indi++) {
        res[indi] = matrix[i][matrix[0].length - 1 - t];
      }
      for (int i = matrix[0].length - 1 - t; i >= t && indi < res.length; i--, indi++) {
        res[indi] = matrix[matrix.length - 1 - t][i];
      }
      for (int i = matrix.length - 1 - 1 - t; i >= t + 1 && indi < res.length; i--, indi++) {
        res[indi] = matrix[i][t];
      }
    }
//    if (indi == res.length - 1) {
//      res[indi] = matrix[matrix.length / 2][matrix.length / 2];
//    }
    return res;
  }
}
