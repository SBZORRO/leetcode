public class No200_NumberOfIslands {
//  Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
//
//  Example 1:
//
//  Input:
//  11110
//  11010
//  11000
//  00000
//
//  Output: 1
//
//  Example 2:
//
//  Input:
//  11000
//  11000
//  00100
//  00011
//
//  Output: 3
//
//
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/number-of-islands
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No200_NumberOfIslands test = new No200_NumberOfIslands();
//    System.out.println(
//        test.numIslands(
//            new char[][] { { 1, 0, 1, 1, 0 }, { 0, 1, 0, 1, 0 }, { 1, 1, 0, 0, 0 },
//                { 0, 0, 0, 0, 0 } }));
    System.out.println(
        test.numIslands(
            new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' } }));
//    System.out.println(
//        test.numIslands(
//            new char[][] { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0 },
//                { 0, 0, 0, 1, 1 } }));

  }

  public int numIslands(char[][] grid) {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        grid[i][j] = (char) (grid[i][j] - '0');
      }
    }
    int res = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          doIsland(grid, i, j);
          res++;
        }
      }
    }
    return res;
  }

  public void doIsland(char[][] grid, int i, int j) {
    if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0) {
      return;
    }

    if (grid[i][j] == 0 || grid[i][j] == 2) {
      return;
    } else if (grid[i][j] == 1) {
      grid[i][j] = 2;
    }

    doIsland(grid, i + 1, j);
    doIsland(grid, i, j + 1);
    doIsland(grid, i - 1, j);
    doIsland(grid, i, j - 1);
    return;
  }
}
