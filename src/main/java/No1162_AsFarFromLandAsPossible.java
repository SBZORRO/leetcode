import java.util.LinkedList;
import java.util.List;

public class No1162_AsFarFromLandAsPossible {
//  Given an N x N grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized and return the distance.
//
//      The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
//
//      If no land or water exists in the grid, return -1.
//
//       
//
//      Example 1:
//
//      Input: [[1,0,1},{0,0,0},{1,0,1]]
//      Output: 2
//      Explanation: 
//      The cell (1, 1) is as far as possible from all the land with distance 2.
//
//      Example 2:
//
//      Input: [[1,0,0},{0,0,0},{0,0,0]]
//      Output: 4
//      Explanation: 
//      The cell (2, 2) is as far as possible from all the land with distance 4.
//
//       
//
//      Note:
//
//          1 <= grid.length == grid[0].length <= 100
//          grid[i][j] is 0 or 1
//
//      来源：力扣（LeetCode）
//      链接：https://leetcode-cn.com/problems/as-far-from-land-as-possible
//      著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No1162_AsFarFromLandAsPossible test = new No1162_AsFarFromLandAsPossible();
    System.out.println(test.maxDistance(new int[][] { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } }));
    System.out.println(test.maxDistance(new int[][] { { 1, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } }));
    System.out.println(
        test.maxDistance(
            new int[][] { { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 } }));
    System.out.println(
        test.maxDistance(
            new int[][] { { 0, 0, 1, 1, 1 }, { 0, 1, 1, 0, 0 }, { 0, 0, 1, 1, 0 },
                { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 1 } }));
    System.out.println(
        test.maxDistance(
            new int[][] { { 1, 0, 0, 0, 0, 1, 0, 0, 0, 1 }, { 1, 1, 0, 1, 1, 1, 0, 1, 1, 0 },
                { 0, 1, 1, 0, 1, 0, 0, 1, 0, 0 }, { 1, 0, 1, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, { 0, 0, 1, 0, 0, 1, 0, 1, 0, 1 },
                { 0, 0, 0, 1, 1, 1, 1, 0, 0, 1 }, { 0, 1, 0, 0, 1, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 1, 0, 0 }, { 1, 1, 0, 1, 1, 1, 1, 1, 0, 0 } }));

  }

  public int maxDistance(int[][] grid) {
    int len = grid.length;
    int count = 0;
    boolean con = true;
    int num = 1;
    while (con) {
      con = false;
      for (int i = 0; i < len; i++) {
        for (int j = 0; j < len; j++) {
          if (grid[i][j] == num) {
            if (i + 1 < len && grid[i + 1][j] == 0) {
              grid[i + 1][j] = num + 1;
              con = true;
            }
            if (j + 1 < len && grid[i][j + 1] == 0) {
              grid[i][j + 1] = num + 1;
              con = true;
            }
            if (i - 1 >= 0 && grid[i - 1][j] == 0) {
              grid[i - 1][j] = num + 1;
              con = true;
            }
            if (j - 1 >= 0 && grid[i][j - 1] == 0) {
              grid[i][j - 1] = num + 1;
              con = true;
            }
          }
        }
      }
      num++;
      if (con == true)
        count++;
    }
    return count == 0 ? -1 : count;
  }

  public int maxDistance1(int[][] grid) {
    if (grid == null || grid.length == 0 || grid.length == 1) {
      return -1;
    }
    int len = grid.length;
    int result = 0;

    int[] pos;
    int r = 0;
    int c = 0;
    boolean con = true;
    List<int[]> list = new LinkedList<int[]>();
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        if (grid[i][j] == 0) {
          int[][] count = new int[len][len];
          con = true;
          list.clear();
          list.add(new int[] { i, j });
          while (list.isEmpty() == false && con == true) {
            pos = list.get(0);
            list.remove(0);
            r = pos[0];
            c = pos[1];

            if (r + 1 < len && r + 1 > i) {
              if (grid[r + 1][c] == 0 && count[r + 1][c] == 0) {
                list.add(new int[] { r + 1, c });
              } else {
                con = false;

              }
            }
            if (r - 1 >= 0 && r - 1 < i) {
              if (grid[r - 1][c] == 0 && count[r - 1][c] == 0) {
                list.add(new int[] { r - 1, c });
              } else {
                con = false;

              }
            }
            if (c + 1 < len && c + 1 > j) {
              if (grid[r][c + 1] == 0 && count[r][c + 1] == 0) {
                list.add(new int[] { r, c + 1 });
              } else {
                con = false;

              }
            }
            if (c - 1 >= 0 && c - 1 < j) {
              if (grid[r][c - 1] == 0 && count[r][c - 1] == 0) {
                list.add(new int[] { r, c - 1 });
              } else {
                con = false;

              }
            }
            if (con == false && list.isEmpty() == false) {
              count[i][j] = Math.abs(r - i) + Math.abs(c - j);
              result = Math.max(result, count[i][j]);
            }
          }
        }
//        count[i][j] = Math.max(count[i][j}, Math.abs(m - i) + Math.abs(n - j));
//        result = Math.max(result, count[i][j]);
      }
    }
    return result == 0 ? -1 : ++result;
  }
}
