public class No151_ReverseWordsInAString {
//  Given an input string, reverse the string word by word.
//
//  
//
//  Example 1:
//
//  Input: "the sky is blue"
//  Output: "blue is sky the"
//
//  Example 2:
//
//  Input: "  hello world!  "
//  Output: "world! hello"
//  Explanation: Your reversed string should not contain leading or trailing spaces.
//
//  Example 3:
//
//  Input: "a good   example"
//  Output: "example good a"
//  Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
//
//   
//
//  Note:
//
//      A word is defined as a sequence of non-space characters.
//      Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
//      You need to reduce multiple spaces between two words to a single space in the reversed string.
//
//   
//
//  Follow up:
//
//  For C programmers, try to solve it in-place in O(1) extra space.
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  public static void main(String[] args) {
    No151_ReverseWordsInAString test = new No151_ReverseWordsInAString();
    System.out.println(test.reverseWords("the sky is blue"));
    System.out.println(test.reverseWords("  hello world!  "));
    System.out.println(test.reverseWords("a good   example"));
    System.out.println(test.reverseWords(" "));
  }

  public String reverseWords(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }
    String[] arr = s.split(" ");
    if (arr.length == 0) {
      return "";
    }
    String temp = "";
    int len = arr.length;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < len / 2; i++) {
      temp = arr[i];
      arr[i] = arr[len - i - 1];
      arr[len - i - 1] = temp;
    }
    for (String ss : arr) {
      if (ss != null && ss.length() != 0) {
        sb.append(ss).append(" ");
      }
    }
    return sb.substring(0, sb.length() - 1).toString();
  }
}
