public class No50_PowXN {
//  Implement pow(x, n), which calculates x raised to the power n (xn).
//
//  Example 1:
//
//  Input: 2.00000, 10
//  Output: 1024.00000
//
//  Example 2:
//
//  Input: 2.10000, 3
//  Output: 9.26100
//
//  Example 3:
//
//  Input: 2.00000, -2
//  Output: 0.25000
//  Explanation: 2-2 = 1/22 = 1/4 = 0.25
//
//  Note:
//
//      -100.0 < x < 100.0
//      n is a 32-bit signed integer, within the range [−231, 231 − 1]
//
//
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/powx-n
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No50_PowXN test = new No50_PowXN();
//    System.out.println(Math.pow(0.00001, 2147483647));
//    System.out.println(test.myPow(0.00001, 2147483647));
    System.out.println(Math.pow(5, -7));
    System.out.println(test.myPow(5, -7));
  }

  public double myPosPow(double x, int n) {
    if (n == 0) {
      return 1;
    }
    if (x == 0 && n != 0) {
      return 0;
    }
    double muln = n % 2 == 0 ? 1 : x;
    double res = myPosPow(x, n / 2);
    return muln * res * res;
  }

  public double myPow(double x, int n) {
    double res = myPosPow(x, n < 0 ? -1 * n : n);
    if (n < 0) {
      return 1 / res;
    }
    return res;
  }
}
