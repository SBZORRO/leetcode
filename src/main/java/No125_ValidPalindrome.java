public class No125_ValidPalindrome {
//  Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
//  Note: For the purpose of this problem, we define empty string as valid palindrome.
//
//  Example 1:
//
//  Input: "A man, a plan, a canal: Panama"
//  Output: true
//
//  Example 2:
//
//  Input: "race a car"
//  Output: false
//
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/valid-palindrome
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No125_ValidPalindrome test = new No125_ValidPalindrome();
//    test.isPalindrome("A man, a plan, a canal: Panama");
//    test.isPalindrome("0P");
    test.isPalindrome("ab2a");
  }

  public boolean isPalindrome(String s) {
    if (s == null || s.length() == 0 || s.length() == 1) {
      return true;
    }
    for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
      while (i <= j
          && ((s.charAt(i) >= 65 && s.charAt(i) <= 90)
              || (s.charAt(i) >= 97 && s.charAt(i) <= 122)
              || (s.charAt(i) >= 48 && s.charAt(i) <= 57)) == false) {
        i++;
      }
      while (i <= j
          && ((s.charAt(j) >= 65 && s.charAt(j) <= 90)
              || (s.charAt(j) >= 97 && s.charAt(j) <= 122)
              || (s.charAt(j) >= 48 && s.charAt(j) <= 57)) == false) {
        j--;
      }
      char a = s.charAt(i);
      char b = s.charAt(j);
      if (i <= j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
        return false;
      }
    }
    return true;
  }
}
