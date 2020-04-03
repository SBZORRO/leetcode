public class No8_StringToInteger {
//  Implement atoi which converts a string to an integer.
//
//  The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
//
//  The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
//
//  If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
//
//  If no valid conversion could be performed, a zero value is returned.
//
//  Note:
//
//      Only the space character ' ' is considered as whitespace character.
//      Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
//
//  Example 1:
//
//  Input: "42"
//  Output: 42
//
//  Example 2:
//
//  Input: "   -42"
//  Output: -42
//  Explanation: The first non-whitespace character is '-', which is the minus sign.
//               Then take as many numerical digits as possible, which gets 42.
//
//  Example 3:
//
//  Input: "4193 with words"
//  Output: 4193
//  Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
//
//  Example 4:
//
//  Input: "words and 987"
//  Output: 0
//  Explanation: The first non-whitespace character is 'w', which is not a numerical 
//               digit or a +/- sign. Therefore no valid conversion could be performed.
//
//  Example 5:
//
//  Input: "-91283472332"
//  Output: -2147483648
//  Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
//               Thefore INT_MIN (−231) is returned.
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/string-to-integer-atoi
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No8_StringToInteger test = new No8_StringToInteger();
    System.out.println(test.myAtoi("-91283472332"));
    System.out.println(test.myAtoi("+1"));
    System.out.println(test.myAtoi("-2147483647"));
  }

  public int myAtoi(String str) {
    int max = Integer.MAX_VALUE / 10;
    int min = Integer.MIN_VALUE / 10;
    int neg = 1;
    int state = 0;
    int result = 0;
    char[] s = str.toCharArray();
    for (int i = 0; i < str.length(); i++) {
      if (s[i] == 0x20 && state == 0) {
        continue;
      }
      if (str.charAt(i) == '-' && state == 0) {
        neg = -1;
        state = 1;
        continue;
      } else if (str.charAt(i) == '+' && state == 0) {
        state = 1;
        continue;
      }
      if ((str.charAt(i) >= 0x30 && str.charAt(i) <= 0x39)) {
        for (int j = i; j < str.length(); j++) {
          if (str.charAt(j) >= 0x30 && str.charAt(j) <= 0x39) {
            if (result * neg < min || (result * neg == min && str.charAt(j) >= '8')) {
              return Integer.MIN_VALUE;
            } else if (result * neg > max || (result * neg == max && str.charAt(j) >= '7')) {
              return Integer.MAX_VALUE;
            }
            result = result * 10 + (str.charAt(j) - 0x30);
          } else {
            return result * neg;
          }
        }
      }
      return result * neg;
    }
    return result * neg;
  }
}
