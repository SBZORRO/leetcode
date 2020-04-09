public class Interview0107_RotateMatrixLCCI {
//  Given an image represented by an N x N matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
//
//      
//
//      Example 1:
//
//      Given matrix = 
//      [
//        [1,2,3],
//        [4,5,6],
//        [7,8,9]
//      ],
//
//      Rotate the matrix in place. It becomes:
//      [
//        [7,4,1],
//        [8,5,2],
//        [9,6,3]
//      ]
//
//      Example 2:
//
//      Given matrix =
//      [
//        [ 5, 1, 9,11],
//        [ 2, 4, 8,10],
//        [13, 3, 6, 7],
//        [15,14,12,16]
//      ], 
//
//      Rotate the matrix in place. It becomes:
//      [
//        [15,13, 2, 5],
//        [14, 3, 4, 1],
//        [12, 6, 8, 9],
//        [16, 7,10,11]
//      ]
//
//
//
//      来源：力扣（LeetCode）
//      链接：https://leetcode-cn.com/problems/rotate-matrix-lcci
//      著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    Interview0107_RotateMatrixLCCI test = new Interview0107_RotateMatrixLCCI();
    test.rotate(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });
  }

  public void rotate(int[][] matrix) {
    int len = matrix.length;
    int[] arr = new int[len];
    int temp = 0;
    for (int i = 0; i < len / 2; i++) {
      arr = matrix[i];
      matrix[i] = matrix[len - 1 - i];
      matrix[len - 1 - i] = arr;
    }
    for (int i = 0; i < len; i++) {
      for (int j = i + 1; j < len; j++) {
        temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }
  }
}
