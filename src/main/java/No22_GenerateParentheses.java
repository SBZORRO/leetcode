import java.util.LinkedList;
import java.util.List;

public class No22_GenerateParentheses {
//  Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//  For example, given n = 3, a solution set is:
//
//  [
//    "((()))",
//    "(()())",
//    "(())()",
//    "()(())",
//    "()()()"
//  ]
//
//
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/generate-parentheses
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No22_GenerateParentheses test = new No22_GenerateParentheses();
    System.out.println(test.generateParenthesis(3));

  }

  public List<String> generateParenthesis(int n) {
    String s = "";
    LinkedList<String> list = new LinkedList<String>();
    list.addLast(s);
    while (true) {
      s = list.pop();
      if (s.length() == 2 * n) {
        list.push(s);
        break;
      }
      String in = in(s);
      String pre = pre(s);
      String post = post(s);

      if (!list.contains(in)) {
        list.addLast(in);
      }
      if (!list.contains(pre)) {
        list.addLast(pre);
      }
      if (!list.contains(post)) {
        list.addLast(post);
      }
    }
    return list;
  }

  public String in(String s) {
    return "(" + s + ")";
  }

  public String pre(String s) {
    return "()" + s;
  }

  public String post(String s) {
    return s + "()";
  }
}