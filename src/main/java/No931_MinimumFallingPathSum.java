import java.util.Arrays;

public class No931_MinimumFallingPathSum {
//  Given a square array of integers A, we want the minimum sum of a falling path through A.
//
//  A falling path starts at any element in the first row, and chooses one element from each row.  The next row's choice must be in a column that is different from the previous row's column by at most one.
//
//   
//
//  Example 1:
//
//  Input: [[1,2,3],[4,5,6],[7,8,9]]
//  Output: 12
//  Explanation: 
//  The possible falling paths are:
//
//      [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
//      [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
//      [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
//
//  The falling path with the smallest sum is [1,4,7], so the answer is 12.
//
//   
//
//  Note:
//
//      1 <= A.length == A[0].length <= 100
//      -100 <= A[i][j] <= 100
//
//
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/minimum-falling-path-sum
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No931_MinimumFallingPathSum test = new No931_MinimumFallingPathSum();
    test.minFallingPathSum(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });
  }

  public int minFallingPathSum(int[][] A) {
    if (A == null || A.length == 0) {
      return 0;
    }
    if (A.length == 1) {
      return A[0][0];
    }
    int top = Integer.MAX_VALUE;
    int tr = Integer.MAX_VALUE;
    int tl = Integer.MAX_VALUE;
    for (int i = 1; i < A.length; i++) {
      for (int j = 0; j < A[0].length; j++) {
        top = A[i - 1][j];
        tr = j + 1 < A.length ? A[i - 1][j + 1] : Integer.MAX_VALUE;
        tl = j - 1 >= 0 ? A[i - 1][j - 1] : Integer.MAX_VALUE;
        A[i][j] = A[i][j] + Math.min(top, Math.min(tr, tl));
      }
    }
    int min = A[A.length - 1][0];
    for (int i = 1; i < A.length; i++) {
      min = Math.min(min, A[A.length - 1][i]);
    }
    return min;
  }

  // 写错了
  // at most one
  // 这个是at least one
  public int minFallingPathSum1(int[][] A) {
    int[] p = Arrays.copyOfRange(A[0], 0, A.length);

    for (int i = 1; i < A.length; i++) {
      for (int j = 0; j < A[0].length; j++) {
        A[i][j] = A[i][j] + min(p, j);
      }
    }
    int min = A[A.length - 1][0];
    for (int i = 1; i < A.length; i++) {
      min = Math.min(min, p[i]);
    }
    return min;
  }

  public int min(int[] a, int i) {
    int tmp = a[i];
    Arrays.sort(a);
    if (a[0] == tmp) {
      return a[1];
    } else {
      return a[0];
    }
  }
}