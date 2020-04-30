class No58_LengthOfLastWord {
//  Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.
//
//      If the last word does not exist, return 0.
//
//      Note: A word is defined as a maximal substring consisting of non-space characters only.
//
//      Example:
//
//      Input: "Hello World"
//      Output: 5
//
//       
//
//      来源：力扣（LeetCode）
//      链接：https://leetcode-cn.com/problems/length-of-last-word
//      著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No58_LengthOfLastWord test = new No58_LengthOfLastWord();
    System.out.println(test.lengthOfLastWord("Hello Wor ld   "));
    System.out.println(test.lengthOfLastWord("Hello World   "));
  }

  public int lengthOfLastWord(String s) {
    s = s.trim();
    if (s.contains(" ")) {
      int i = s.lastIndexOf(' ');
      return s.substring(i + 1).length();
    } else {
      return s.length();
    }
  }
}
