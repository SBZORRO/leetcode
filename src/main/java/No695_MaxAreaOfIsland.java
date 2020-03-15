public class No695_MaxAreaOfIsland {
//  Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
//
//  Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
//
//  Example 1:
//
//  [[0,0,1,0,0,0,0,1,0,0,0,0,0],
//   [0,0,0,0,0,0,0,1,1,1,0,0,0],
//   [0,1,1,0,1,0,0,0,0,0,0,0,0],
//   [0,1,0,0,1,1,0,0,1,0,1,0,0],
//   [0,1,0,0,1,1,0,0,1,1,1,0,0],
//   [0,0,0,0,0,0,0,0,0,0,1,0,0],
//   [0,0,0,0,0,0,0,1,1,1,0,0,0],
//   [0,0,0,0,0,0,0,1,1,0,0,0,0]]
//
//  Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
//
//  Example 2:
//
//  [[0,0,0,0,0,0,0,0]]
//
//  Given the above grid, return 0.
//
//  Note: The length of each dimension in the given grid does not exceed 50.
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/max-area-of-island
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No695_MaxAreaOfIsland test = new No695_MaxAreaOfIsland();
    //4
    System.out.println(
        test.maxAreaOfIsland(
            new int[][] { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 1, 1 },
                { 0, 0, 0, 1, 1 } }));
    //4
    System.out.println(
        test.maxAreaOfIsland(
            new int[][] { { 0, 1 }, { 1, 1 }, { 1, 0 } }));
//5
    System.out.println(
        test.maxAreaOfIsland(
            new int[][] { { 0, 1 }, { 1, 1 }, { 1, 1 } }));
//6
    System.out.println(
        test.maxAreaOfIsland(
            new int[][] { { 0, 0, 1 }, { 1, 1, 1 }, { 1, 1, 0 } }));
//14
    System.out.println(
        test.maxAreaOfIsland(
            new int[][] { { 1, 1, 0, 1, 0, 0, 1, 1 }, { 0, 1, 0, 1, 1, 1, 1, 0 },
                { 1, 1, 1, 1, 0, 0, 0, 1 } }));
  }

  int max = 0;

  public int maxAreaOfIsland(int[][] grid) {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] != 0) {

          max = Math.max(max, iter(grid, i, j));
        }
      }
    }
    return max;
  }

  public int iter(int[][] grid, int i, int j) {
    int res = 0;
    if (i < 0 || j < 0 || j >= grid[0].length || i >= grid.length) {
      return 0;
    }

    if (grid[i][j] == 1) {
      grid[i][j] = 0;
      res = 1;
    } else {
      return 0;
    }

    res += iter(grid, i, j - 1);

    res += iter(grid, i - 1, j);

    res += iter(grid, i, j + 1);

    res += iter(grid, i + 1, j);
    return res;
  }

  static class MutableInt {
    int val = 0;

    public MutableInt(int i) {
      val = i;
    }
  }

  public int maxAreaOfIsland1(int[][] grid) {
    MutableInt[][] mia = new MutableInt[grid.length][grid[0].length];

    int max = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] != 0) {
          MutableInt next = null;
          MutableInt self = mia[i][j];
          MutableInt target = null;

          if (self == null) {
            mia[i][j] = new MutableInt(1);
            self = mia[i][j];
          }

          if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
            next = mia[i][j + 1];
            if (self != next)
              if (next != null) {

                int sum = self.val + next.val;
                target = self;
                self.val = sum;
                next.val = sum;
                self = next;

              } else if (next == null) {
                mia[i][j + 1] = self;
                self.val++;

              }

          }
          if (i + 1 < grid.length && grid[i + 1][j] == 1) {
            mia[i + 1][j] = self;
            self.val++;
            if (target != null) {
              target.val = 0;
            }
          }
          max = Math.max(max, mia[i][j].val);
        }
      }
    }
    return max;
  }
}
