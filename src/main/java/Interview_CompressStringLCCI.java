public class Interview_CompressStringLCCI {
//  Implement a method to perform basic string compression using the counts of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the "compressed" string would not become smaller than the original string, your method should return the original string. You can assume the string has only uppercase and lowercase letters (a - z).
//
//      Example 1:
//
//      Input: "aabcccccaaa"
//      Output: "a2b1c5a3"
//
//      Example 2:
//
//      Input: "abbccd"
//      Output: "abbccd"
//      Explanation: 
//      The compressed string is "a1b2c2d1", which is longer than the original string.
//
//       
//
//      Note:
//
//          0 <= S.length <= 50000
//
//      来源：力扣（LeetCode）
//      链接：https://leetcode-cn.com/problems/compress-string-lcci
//      著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    Interview_CompressStringLCCI test = new Interview_CompressStringLCCI();
    System.out.println(test.compressString("aabcccccaaa"));
    System.out.println(test.compressString("abbccd"));
  }

  public String compressString(String S) {
    if (S == null || S.length() == 0) {
      return "";
    }
    char cur = S.charAt(0);
    int len = 0;
    StringBuilder code = new StringBuilder();
    for (char c : S.toCharArray()) {
      if (cur != c) {
        code.append(cur);
        code.append(String.valueOf(len));
        cur = c;
        len = 1;
      } else {
        len++;
      }
    }
    code.append(cur);
    code.append(String.valueOf(len));
    if (S.length() <= code.length()) {
      return S;
    } else {
      return code.toString();
    }
  }
}
