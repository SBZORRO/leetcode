import java.util.LinkedList;

public class No394_DecodeString {
//  Given an encoded string, return its decoded string.
//
//      The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
//
//      You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
//
//      Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
//
//      Examples:
//
//      s = "3[a]2[bc]", return "aaabcbc".
//      s = "3[a2[c]]", return "accaccacc".
//      s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
//
//
//      来源：力扣（LeetCode）
//      链接：https://leetcode-cn.com/problems/decode-string
//      著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No394_DecodeString test = new No394_DecodeString();
//    System.out.println(test.decodeString("100[leetcode]"));
    System.out.println(test.decodeString("3[a10[bc]]"));

  }

  public String decodeString(String s) {
    LinkedList<Integer> li = new LinkedList<>();
    LinkedList<Integer> li2 = new LinkedList<>();
    LinkedList<Integer> li3 = new LinkedList<>();

    StringBuilder sb = new StringBuilder(s);

    int i = 0;
    int j = 0;
    int num = 0;
    while (i < sb.length()) {
      char c = sb.charAt(i);
      if (c >= 48 && c <= 57 && num == 0) {
        j = i;
        while (c >= 48 && c <= 57) {
          num = (c - '0') + num * 10;
          c = sb.charAt(++j);
        }
        j = j - i + 1;
        li.addFirst(i);
        li2.addFirst(num);
        li3.addFirst(j);
      } else if (c == ']') {
        int beg = li.pop();
        int mul = li2.pop();
        int gap = li3.pop();
        String rep = repeatString(mul, sb.substring(beg + gap, i));
        sb.replace(beg, i + 1, rep);
        i = beg + rep.length() - 1;
      } else if (c == '[') {
        num = 0;
      }
      i++;
    }
    return sb.toString();
  }

  public String repeatString(int n, String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      sb.append(s);
    }
    return sb.toString();
  }
}
