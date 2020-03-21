public class No409_LongestPalindrome {
//  Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
//
//  This is case sensitive, for example "Aa" is not considered a palindrome here.
//
//  Note:
//  Assume the length of given string will not exceed 1,010.
//
//  Example:
//
//  Input:
//  "abccccdd"
//
//  Output:
//  7
//
//  Explanation:
//  One longest palindrome that can be built is "dccaccd", whose length is 7.

  public static void main(String[] args) {
    No409_LongestPalindrome test = new No409_LongestPalindrome();
    System.out.println(test.longestPalindrome("tmmzuxt"));
    System.out.println(test.longestPalindrome("abccccdd"));
    System.out.println(test.longestPalindrome("ccc"));
    System.out.println(test.longestPalindrome("abcccccdd"));
    System.out.println(test.longestPalindrome("TMMZUXT"));
    System.out.println(test.longestPalindrome("ABCCCCDD"));
    System.out.println(test.longestPalindrome("CCC"));
    System.out.println(test.longestPalindrome("ABCCCCCDD"));
    System.out.println(test.longestPalindrome("AAA"));
  }

  public int longestPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int[] dict = new int[58];
    for (char c : s.toCharArray()) {
      dict[c - 'A']++;
    }
    int result = 0;
    for (int i : dict) {
      if (i % 2 != 0) {
        result += 1;
      }
    }
    return result == 0 ? s.length() : s.length() - result + 1;
  }

  public int longestPalindrome1(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int[] dict = new int[58];
    for (char c : s.toCharArray()) {
      dict[c - 'A']++;
    }
    int result = 0;
    int plusOne = 0;
    for (int i : dict) {
      if (i != 1) {
        if (i % 2 == 0) {
          result += i;
        } else {
          result = result + i - 1;
          plusOne = 1;
        }
      } else {
        plusOne = 1;
      }
    }
    return result + plusOne;
  }
}