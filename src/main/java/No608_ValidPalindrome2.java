public class No608_ValidPalindrome2 {
//  Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
//
//  Example 1:
//
//  Input: "aba"
//  Output: True
//
//  Example 2:
//
//  Input: "abca"
//  Output: True
//  Explanation: You could delete the character 'c'.
//
//  Note:
//
//      The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
//
//
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/valid-palindrome-ii
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No608_ValidPalindrome2 test = new No608_ValidPalindrome2();
//    System.out.println(test.validPalindrome("abca"));
//    System.out.println(test.validPalindrome("abaca"));
    System.out.println(test.validPalindrome("axcbabca"));
  }

  public boolean validPalindrome(String s) {
    StringBuilder sb = new StringBuilder(s).reverse();
    String z = sb.toString();
    if (s.equals(z)) {
      return true;
    }
    for (int i = 0, j = 0; i < (s.length() + 1) / 2 && j < (s.length() + 1); i++, j++) {
      if (s.charAt(i) != z.charAt(j)) {
        String ss = s.substring(i, (s.length() + 1) / 2 + 1);
        String zs = z.substring(i, (s.length() + 1) / 2 + 1);
        if (ss.substring(1, ss.length()).equals(zs.substring(0, zs.length() - 1))
            || ss.substring(0, ss.length() - 1).equals(zs.subSequence(1, zs.length()))) {
          return true;
        } else {
          return false;
        }
      }
    }
    return true;

  }
}