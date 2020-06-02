public class No258_AddDigits {
//  Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
//
//  Example:
//
//  Input: 38
//  Output: 2 
//  Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. 
//               Since 2 has only one digit, return it.
//
//  Follow up:
//  Could you do it without any loop/recursion in O(1) runtime?
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/add-digits
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No258_AddDigits test = new No258_AddDigits();

  }

  // s1 = 100a + 10b + c
  // s2 = a + b + c
  // s1 - s2 =  99a + 9b
  // s2 到 s1 增加了9的倍数, 循环了9的倍数
  // s1 = s2 (mod 9)
  public int addDigits(int num) {
    if (num > 9) {
      num = num % 9;
      if (num == 0)
        return 9;
    }
    return num;
  }

  public int addDigits1(int num) {
    if (num < 10) {
      return num;
    }
    int sum = 0;
    while (num > 0) {
      int rem = num % 10;
      int div = num / 10;
      sum += rem;
      num = div;
    }
    return addDigits(sum);
  }
}