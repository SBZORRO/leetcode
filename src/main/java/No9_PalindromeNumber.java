import java.util.ArrayList;

class No9_PalindromeNumber {
//  Given a 32-bit signed integer, reverse digits of an integer.
//
//  Example 1:
//
//  Input: 123
//  Output: 321
//
//  Example 2:
//
//  Input: -123
//  Output: -321
//
//  Example 3:
//
//  Input: 120
//  Output: 21
//
//  Note:
//  Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/reverse-integer
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No9_PalindromeNumber test = new No9_PalindromeNumber();
    System.out.println(test.isPalindrome(100));
  }

  public boolean isPalindrome1(int x) {
    if (x < 0) {
      return false;
    }

    ArrayList<Integer> list = new ArrayList<>();
    while (x > 0) {
      int div = x / 10;
      int rem = x % 10;
      list.add(rem);
      x = div;
    }

    for (int i = 0; i < list.size() / 2; i++) {
      if (list.get(i) != list.get(list.size() - i - 1)) {
        return false;
      }
    }
    return true;
  }

  public boolean isPalindrome(int x) {
    if (x < 10 && x >= 0) {
      return true;
    }
    if (x < 0 || x % 10 == 0) {
      return false;
    }
    int newNum = 0;
    int div = 0;
    int rem = 0;
    while (newNum < x) {
      div = x / 10;
      rem = x % 10;
      newNum = newNum * 10 + rem;
      x = div;
    }

    return newNum == x ? true : newNum / 10 == x;
  }
}
