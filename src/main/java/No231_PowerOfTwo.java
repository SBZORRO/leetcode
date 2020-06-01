public class No231_PowerOfTwo {
//  Given an integer, write a function to determine if it is a power of two.
//
//  Example 1:
//
//  Input: 1
//  Output: true 
//  Explanation: 20 = 1
//
//  Example 2:
//
//  Input: 16
//  Output: true
//  Explanation: 24 = 16
//
//  Example 3:
//
//  Input: 218
//  Output: false
//
//
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/power-of-two
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No231_PowerOfTwo test = new No231_PowerOfTwo();

  }

  public boolean isPowerOfTwo(int n) {
    if (n == 0) {
      return false;
    }
    long x = (long) n;
    return (x & (-x)) == x;
  }

  public boolean isPowerOfTwo2(int n) {
    if (n == 0) {
      return false;
    }
    long x = (long) n;
    return (x & (x - 1)) == 0;
  }

  public boolean isPowerOfTwo1(int n) {
    if (n == 0) {
      return false;
    }
    int op = 1;
    for (int i = 0; i < 31; i++) {
      if (n == op << i) {
        return true;
      }
    }
    return false;
  }
}