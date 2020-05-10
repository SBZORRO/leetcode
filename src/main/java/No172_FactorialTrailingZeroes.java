class No172_FactorialTrailingZeroes {
//  Given an integer n, return the number of trailing zeroes in n!.
//
//      Example 1:
//
//      Input: 3
//      Output: 0
//      Explanation: 3! = 6, no trailing zero.
//
//      Example 2:
//
//      Input: 5
//      Output: 1
//      Explanation: 5! = 120, one trailing zero.
//
//      Note: Your solution should be in logarithmic time complexity.
//
//      来源：力扣（LeetCode）
//      链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes
//      著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No172_FactorialTrailingZeroes test = new No172_FactorialTrailingZeroes();
  }

  public int trailingZeroes(int n) {
    int i = n / 5;
    int res = i;
    while (i >= 5) {
      i = i / 5;
      res += i;
    }
    return res;
  }
}
