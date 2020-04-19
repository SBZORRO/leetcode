import java.util.Stack;

public class Interview13_ScopeOfRobot {
//  地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
//
//      
//
//      示例 1：
//
//      输入：m = 2, n = 3, k = 1
//      输出：3
//
//      示例 1：
//
//      输入：m = 3, n = 1, k = 0
//      输出：1
//
//      提示：
//
//          1 <= n,m <= 100
//          0 <= k <= 20
//
//      来源：力扣（LeetCode）
//      链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
//      著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    Interview13_ScopeOfRobot test = new Interview13_ScopeOfRobot();
    System.out.println(test.count(2));
    System.out.println(test.movingCount(2, 3, 1));
    System.out.println(test.movingCount(3, 1, 0));
  }

  public int movingCount(int m, int n, int k) {
    int[][] arr = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        arr[i][j] = count(i) + count(j);
      }
    }
    Stack<int[]> stack = new Stack<>();
    stack.push(new int[] { 0, 0 });
    int res = 0;
    while (stack.isEmpty() == false) {
      int[] pos = stack.pop();
      if (arr[pos[0]][pos[1]] <= k && arr[pos[0]][pos[1]] >= 0) {
        if (pos[0] + 1 < m)
          stack.push(new int[] { pos[0] + 1, pos[1] });
        if (pos[1] + 1 < n)
          stack.push(new int[] { pos[0], pos[1] + 1 });
        res++;
        arr[pos[0]][pos[1]] = -1;
      }
    }
    return res;
  }

  public int count(int i) {
    if (i == 0) {
      return 0;
    }
    int div = i / 10;
    int rem = i % 10;
    if (div > 0) {

    }
    return rem + count(div);

  }
}