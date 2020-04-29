public class No38_CountAndSay {
//  The count-and-say sequence is the sequence of integers with the first five terms as following:
//
//    1.     1
//    2.     11
//    3.     21
//    4.     1211
//    5.     111221
//
//    1 is read off as "one 1" or 11.
//    11 is read off as "two 1s" or 21.
//    21 is read off as "one 2, then one 1" or 1211.
//
//    Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence. You can do so recursively, in other words from the previous member read off the digits, counting the number of digits in groups of the same digit.
//
//    Note: Each term of the sequence of integers will be represented as a string.
//
//     
//
//    Example 1:
//
//    Input: 1
//    Output: "1"
//    Explanation: This is the base case.
//
//    Example 2:
//
//    Input: 4
//    Output: "1211"
//    Explanation: For n = 3 the term was "21" in which we have two groups "2" and "1", "2" can be read as "12" which means frequency = 1 and value = 2, the same way "1" is read as "11", so the answer is the concatenation of "12" and "11" which is "1211".
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/count-and-say
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No38_CountAndSay test = new No38_CountAndSay();
    char c = 1;
    System.out.println(test.lastSameSeq("1211"));
    System.out.println(test.lastSameSeq("111221"));
    System.out.println(test.countAndSay(10));
  }

  public String countAndSay(int n) {
    String s = "1";
    for (int i = 1; i < n; i++) {
      s = lastSameSeq(s);
    }
    return s;
  }

  public String lastSameSeq(String s) {
    StringBuilder sb = new StringBuilder();
    int i = 0;
    int j = 0;

    while (j < s.length()) {
      char c = s.charAt(j);
      char cc = c;
      i = 0;
      while (cc == c) {
        i++;
        j++;
        if (j >= s.length()) {
          break;
        }
        cc = s.charAt(j);
      }
      sb.append(i + "" + c);
      if (j >= s.length()) {
        break;
      }
    }
    return sb.toString();
  }

  public String lastSameSeq1(String s, int beg) {
    char c = s.charAt(0);
    char cc = c;
    int i = 0;
    for (i = 1; cc == c; i++) {
      cc = s.charAt(i);
    }

    return i - 1 + "" + c;
  }
}