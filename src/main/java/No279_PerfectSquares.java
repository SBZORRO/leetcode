import java.util.Arrays;

class No279_PerfectSquares {
//  Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
//
//  Example 1:
//
//  Input: n = 12
//  Output: 3 
//  Explanation: 12 = 4 + 4 + 4.
//
//  Example 2:
//
//  Input: n = 13
//  Output: 2
//  Explanation: 13 = 4 + 9.
//
//
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/perfect-squares
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No279_PerfectSquares test = new No279_PerfectSquares();

  }

  public int numSquares(int n) {
    int[] p = new int[n];
    Arrays.fill(p, Integer.MAX_VALUE);
    return numSquares(n, p);
  }

  public int numSquares(int n, int[] p) {
    if (n <= 0) {
      return 0;
    }
    int sqrt = (int) Math.sqrt(n);
    if (sqrt * sqrt == n) {
      return 1;
    }
    int min = Integer.MAX_VALUE;
    for (int i = 1; i <= sqrt; i++) {
      int i2 = (int) Math.pow(i, 2);
      p[n - i2] = p[n - i2] == Integer.MAX_VALUE ? numSquares(n - i2, p) : p[n - i2];
      if (p[n - i2] != 0) {
        min = Math.min(min, 1 + p[n - i2]);
      }
    }
    return min;
  }
}
