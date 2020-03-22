public class No5_LongestPalindromicSubstring {
//  Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
//
//  Example 1:
//
//  Input: "babad"
//  Output: "bab"
//  Note: "aba" is also a valid answer.
//
//  Example 2:
//
//  Input: "cbbd"
//  Output: "bb"
//
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/longest-palindromic-substring
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No5_LongestPalindromicSubstring cc = new No5_LongestPalindromicSubstring();
    System.out.println(cc.longestPalindrome("tmmzuxt"));
    System.out.println(cc.longestPalindrome("babad"));
    System.out.println(cc.longestPalindrome("cbbd"));
    System.out.println(cc.longestPalindrome("abcda"));
    System.out.println(cc.longestPalindrome("aacdefcaa"));

  }

  public String longestPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return "";
    } else if (s.length() == 1) {
      return s;
    }

    char[] rev = new char[s.length()];
    char[] ori = s.toCharArray();
    int len = s.length();
    int[][] tab = new int[len][len];
    for (int j = 0, i = s.length() - 1; i >= 0; i--, j++) {
      rev[j] = ori[i];
    }

    int max = 0;
    int beg = 0;
    int end = 0;

    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        if (ori[i] == rev[j]) {
          if (i > 0 && j > 0) {
            tab[i][j] = tab[i - 1][j - 1] + 1;
          } else {
            tab[i][j] = 1;
          }
          if (max <= tab[i][j]) {
            if (len - j - 1 - 1 + tab[i][j] == i) {
              end = i;
              beg = len - j - 1;
              max = tab[i][j];
            }
          }
        }
      }
    }
    return s.substring(beg, end + 1);
  }

}