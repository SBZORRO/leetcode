public class No91_DecodeWays {
//  A message containing letters from A-Z is being encoded to numbers using the following mapping:
//
//    'A' -> 1
//    'B' -> 2
//    ...
//    'Z' -> 26
//
//    Given a non-empty string containing only digits, determine the total number of ways to decode it.
//
//    Example 1:
//
//    Input: "12"
//    Output: 2
//    Explanation: It could be decoded as "AB" (1 2) or "L" (12).
//
//    Example 2:
//
//    Input: "226"
//    Output: 3
//    Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/decode-ways
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  public static void main(String[] args) {
    No91_DecodeWays test = new No91_DecodeWays();
    test.numDecodings("100");

  }

  // 超出时间限制
  public int numDecodings(String s) {
    if (s == null || s.length() == 0) {
      return 1;
    }
    if (s.length() == 1) {
      if (Integer.valueOf(s) == 0) {
        return 0;
      } else {
        return 1;
      }
    }
    if (s.contains("00")) {
      return 0;
    }
    String s1 = s.substring(s.length() - 1);
    String s2 = s.substring(s.length() - 2);
    int i = Integer.valueOf(s1);
    int j = Integer.valueOf(s2);
    if (i == 0 && j > 26) {
      return 0;
    } else if (i == 0 && j <= 26) {
      return numDecodings(s.substring(0, s.length() - 2));
    } else if (j <= 26 && j > 10) {
      return numDecodings(s.substring(0, s.length() - 1))
          + numDecodings(s.substring(0, s.length() - 2));
    } else {
      return numDecodings(s.substring(0, s.length() - 1));
    }
  }
}
