public class No892_SurfaceAreaOf3DShapes {
//  On a N * N grid, we place some 1 * 1 * 1 cubes.
//
//  Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
//
//  Return the total surface area of the resulting shapes.
//
//   
//
//  Example 1:
//
//  Input: [[2]]
//  Output: 10
//
//  Example 2:
//
//  Input: [[1,2],[3,4]]
//  Output: 34
//
//  Example 3:
//
//  Input: [[1,0],[0,2]]
//  Output: 16
//
//  Example 4:
//
//  Input: [[1,1,1],[1,0,1],[1,1,1]]
//  Output: 32
//
//  Example 5:
//
//  Input: [[2,2,2],[2,1,2],[2,2,2]]
//  Output: 46
//
//   
//
//  Note:
//
//      1 <= N <= 50
//      0 <= grid[i][j] <= 50
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/surface-area-of-3d-shapes
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  public static void main(String[] args) {
    No892_SurfaceAreaOf3DShapes test = new No892_SurfaceAreaOf3DShapes();
    System.out.println(test.surfaceArea(new int[][] { { 2 } }));
    System.out.println(test.surfaceArea(new int[][] { { 8, 8 } }));
    System.out.println(test.surfaceArea(new int[][] { { 8 }, { 8 } }));
    System.out.println(test.surfaceArea(new int[][] { { 0, 0 }, { 0, 0 } }));
    System.out.println(test.surfaceArea(new int[][] { { 1, 2 }, { 3, 4 } }));
    System.out.println(test.surfaceArea(new int[][] { { 1, 0 }, { 0, 2 } }));
    System.out.println(test.surfaceArea(new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } }));
    System.out.println(test.surfaceArea(new int[][] { { 2, 2, 2 }, { 2, 1, 2 }, { 2, 2, 2 } }));

  }

  public int surfaceArea(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    int result = 0;
    int cur = 0;
    int right = 0;
    int bot = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {

        cur = grid[i][j];

        if (cur == 0) {
          continue;
        } else {
          if (i + 1 < grid.length) {
            bot = grid[i + 1][j];
          } else {
            bot = 0;
          }
          if (j + 1 < grid[0].length) {
            right = grid[i][j + 1];
          } else {
            right = 0;
          }
          result += cur * 6 - (cur - 1) * 2;
          if (right > 0) {
            result -= (cur > right ? right * 2 : cur * 2);
          }
          if (bot > 0) {
            result -= cur > bot ? bot * 2 : cur * 2;
          }
        }
      }
    }
    return result;
  }
}
