class No66_PlusOne {
//  Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
//
//  The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
//
//  You may assume the integer does not contain any leading zero, except the number 0 itself.
//
//  Example 1:
//
//  Input: [1,2,3]
//  Output: [1,2,4]
//  Explanation: The array represents the integer 123.
//
//  Example 2:
//
//  Input: [4,3,2,1]
//  Output: [4,3,2,2]
//  Explanation: The array represents the integer 4321.
//
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/plus-one
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No66_PlusOne test = new No66_PlusOne();
  }

  public int[] plusOne(int[] digits) {
    int plusOne = 0;
    int cur = 0;
    for (int i = digits.length - 1, j = digits.length - 1; i >= 0 && j >= 0; i--, j--) {
      cur = digits[i];
      if (cur == 9) {
        digits[i] = 0;
      } else {
        digits[i]++;
        plusOne = 1;
        break;
      }
    }
    if (plusOne == 0) {
      int[] addone = new int[digits.length + 1];
      addone[0] = 1;
      for (int i = 0; i < digits.length; i++) {
        addone[i + 1] = digits[i];
      }
      return addone;
    } else {
      return digits;
    }

  }
}
