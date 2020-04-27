public class Inteerview0811_CoinLCCI {
//  Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents), and pennies (1 cent), write code to calculate the number of ways of representing n cents. (The result may be large, so you should return it modulo 1000000007)
//
//  Example1:
//
//   Input: n = 5
//   Output: 2
//   Explanation: There are two ways:
//  5=5
//  5=1+1+1+1+1
//
//  Example2:
//
//   Input: n = 10
//   Output: 4
//   Explanation: There are four ways:
//  10=10
//  10=5+5
//  10=5+1+1+1+1+1
//  10=1+1+1+1+1+1+1+1+1+1
//
//  Notes:
//
//  You can assume:
//
//      0 <= n <= 1000000
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/coin-lcci
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    Inteerview0811_CoinLCCI test = new Inteerview0811_CoinLCCI();
    System.out.println();

  }

  public int waysToChange(int n) {
    int[] c = new int[] { 1, 5, 10, 25 };
    int[][] res = new int[4][n / 5];

    for (int i = 0; i < res[0].length; i++) {
      res[0][i] = 1;
    }
    for (int i = 0; i < 4; i++) {
      res[i][0] = 1;
    }
    for (int i = 1; i < c.length; i++) {
      for (int j = 0; j < res[0].length; j++) {

      }
    }
    return res[3][n / 5 - 1];
  }

  public int waysToChange1(int n) {
    int[] border = new int[4];
    border[0] = n / 25;
    border[1] = n / 10;
    border[2] = n / 5;
    int counter = 0;
    for (int i = 0; i <= border[0]; i++) {
      for (int j = 0; j <= border[1]; j++) {
        for (int k = 0; k <= border[2]; k++) {
          if (i * 25 + j * 10 + k * 5 > n) {
            break;
          } else {
            counter++;
          }
        }
      }
    }
    return counter;
  }
}
