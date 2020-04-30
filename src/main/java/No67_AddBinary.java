public class No67_AddBinary {
//  Given two binary strings, return their sum (also a binary string).
//
//      The input strings are both non-empty and contains only characters 1 or 0.
//
//      Example 1:
//
//      Input: a = "11", b = "1"
//      Output: "100"
//
//      Example 2:
//
//      Input: a = "1010", b = "1011"
//      Output: "10101"
//

//       
//
//      Constraints:
//
//          Each string consists only of '0' or '1' characters.
//          1 <= a.length, b.length <= 10^4
//          Each string is either "0" or doesn't contain any leading zero.
//
//      来源：力扣（LeetCode）
//      链接：https://leetcode-cn.com/problems/add-binary
//      著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No67_AddBinary test = new No67_AddBinary();
    System.out.println(test.addBinary("11", "1"));
    System.out.println(test.addBinary("1010", "1011"));
    System.out.println(test.addBinary("110101010", "10101010101"));
  }

  public String addBinary(String a, String b) {
    int alen = a.length();
    int blen = b.length();
    int len = Math.max(alen, blen);
    int m = 0;
    int n = 0;
    int andOne = 0;
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < len; i++) {
      m = alen - i - 1 >= 0 ? a.charAt(alen - i - 1) - 48 : 0;
      n = blen - i - 1 >= 0 ? b.charAt(blen - i - 1) - 48 : 0;

      if ((m & n) == 0) {
        if ((m ^ n) == 0) {
          sb.append(andOne);
          andOne = 0;
        } else {
          if (andOne == 1) {
            sb.append(0);
          } else if (andOne == 0) {
            sb.append(1);
          }
        }
      } else if ((m & n) == 1) {
        sb.append(andOne);
        andOne = 1;
      }
    }
    if (andOne == 1) {
      sb.append(andOne);
    }
    return sb.reverse().toString();
  }
}
