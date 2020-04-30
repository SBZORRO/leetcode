import java.util.LinkedList;
import java.util.List;

class No202_HappyNumber {
//  Write an algorithm to determine if a number n is "happy".
//
//  A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
//
//  Return True if n is a happy number, and False if not.
//
//  Example: 
//
//  Input: 19
//  Output: true
//  Explanation: 
//  12 + 92 = 82
//  82 + 22 = 68
//  62 + 82 = 100
//  12 + 02 + 02 = 1
//
//
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/happy-number
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No202_HappyNumber test = new No202_HappyNumber();

//    System.out.print(test.numberOfSubarrays(new int[] { 1, 1, 2, 1, 1 }, 3));
    System.out.print(test.isHappy(19));
  }

  public boolean isHappy(int n) {
    int res = n;
    List<Integer> li = new LinkedList<>();
    while (res != 1) {
      if (li.contains(res)) {
        return false;
      } else {
        li.add(res);
      }
      res = cal(res);
    }
    return true;
  }

  public int cal(int n) {
    int res = 0;

    int rem = n % 10;
    int div = n / 10;

    while (rem != 0 || div != 0) {
      res = res + (int) Math.pow(rem, 2);

      rem = div % 10;
      div = div / 10;

    }
    return res;
  }
}
