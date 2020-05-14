public class No64_MinimumPathSum {
//  Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
//
//  Note: You can only move either down or right at any point in time.
//
//  Example:
//
//  Input:
//  [
//    [1,3,1],
//    [1,5,1],
//    [4,2,1]
//  ]
//  Output: 7
//  Explanation: Because the path 1→3→1→1→1 minimizes the sum.
//
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/minimum-path-sum
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No64_MinimumPathSum test = new No64_MinimumPathSum();
    test.minPathSum(new int[][] { { 1, 2, 5 }, { 3, 2, 1 } });
  }

  public int minPathSum(int[][] grid) {
    int[][] p = new int[grid.length][grid[0].length];
    p[0][0] = grid[0][0];
    int sum = grid[0][0];
    for (int i = 1; i < grid.length; i++) {
      sum += grid[i][0];
      p[i][0] = sum;
    }
    sum = grid[0][0];
    for (int j = 1; j < grid[0].length; j++) {
      sum += grid[0][j];
      p[0][j] = sum;
    }
    for (int i = 1; i < grid.length; i++) {
      for (int j = 1; j < grid[0].length; j++) {
        p[i][j] = Math.min(p[i - 1][j] + grid[i][j], p[i][j - 1] + grid[i][j]);
      }
    }
    return p[grid.length - 1][grid[0].length - 1];
  }
}
