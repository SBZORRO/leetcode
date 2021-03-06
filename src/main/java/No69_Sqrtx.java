public class No69_Sqrtx {
//  Implement int sqrt(int x).
//
//  Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
//
//  Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
//
//  Example 1:
//
//  Input: 4
//  Output: 2
//
//  Example 2:
//
//  Input: 8
//  Output: 2
//  Explanation: The square root of 8 is 2.82842..., and since 
//               the decimal part is truncated, 2 is returned.
//
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/sqrtx
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  public static void main(String[] args) {
    No69_Sqrtx test = new No69_Sqrtx();
//    System.out.println(test.mySqrt(9));
//    System.out.println(test.mySqrt(8));
//    System.out.println(test.mySqrt(23452345));
//    System.out.println(test.mySqrt(2147395599));
    System.out.println(test.mySqrt(2147483647));

  }

  public int mySqrt(int x) {
    int temp = x;
    int i = 0;
    for (i = 0; temp != 0; i++) {
      temp = temp >> 1;
    }

    int beg = x >> ((i + 1) / 2);
    int end = (x | (-1 >>> (31 - i + 1))) >> (i / 2);
    int mid = (beg + end) / 2;
    int res = mid * mid;
    while (mid != beg && mid != end) {
      if (x == res) {
        return mid;
      } else if (res < 0 || x < res) {
        end = mid;
        mid = (beg + end) / 2;
        res = mid * mid;
      } else if (x > res) {
        beg = mid;
        mid = (beg + end) / 2;
        res = mid * mid;

      }
    }

    if (x == res) {
      return mid;
    } else if (x >= end * end && end * end > 0) {
      return end;
    } else {
      return beg;
    }
  }
}
