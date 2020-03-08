public class CoinChange {
//  You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
//
//      Example 1:
//
//      Input: coins = [1, 2, 5], amount = 11
//      Output: 3 
//      Explanation: 11 = 5 + 5 + 1
//
//      Example 2:
//
//      Input: coins = [2], amount = 3
//      Output: -1
//
//      Note:
//      You may assume that you have an infinite number of each kind of coin.
//
//      来源：力扣（LeetCode）
//      链接：https://leetcode-cn.com/problems/coin-change
//      著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    CoinChange cc = new CoinChange();
//    [186,419,83,408]
//        6249
    System.out.println(cc.coinChange(new int[] { 1, 2, 5 }, 11));
    System.out.println(cc.coinChange(new int[] { 2, 5, 10, 1 }, 27));
    System.out.println(cc.coinChange(new int[] { 186, 419, 83, 408 }, 6249));
  }

  public int coinChange(int[] coins, int amount) {
//    Arrays.sort(coins);
    return iter(coins, coins.length, amount);
//    int result =0;
//    result = iter(coins, coins.length, amount);
//    if ()
  }

  public int iter(int[] coins, int length, int amount) {
    if (amount == 0) {
      return 0;
    }
    if (length == 0) {
      return -1;
    }
    int cur = length - 1;
    int div = amount / coins[cur];
    int rem = amount % coins[cur];
    int minDiv = -1;
    int nextDiv = 0;
    if (rem == 0) {
      minDiv = div;
    }

    while (div >= 0) {
      nextDiv = iter(coins, cur, rem);
      if (nextDiv == -1 && div == 0) {
        return minDiv;
      } else {

        if (nextDiv > 0) {
          if (minDiv == -1 || (div + nextDiv < minDiv)) {
            minDiv = div + nextDiv;
          }
        }
        div--;
        rem = rem + coins[cur];
      }
    }
    return minDiv;

  }
}