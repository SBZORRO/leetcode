import java.util.Stack;

class ValidParentheses {
//  Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//  An input string is valid if:
//
//      Open brackets must be closed by the same type of brackets.
//      Open brackets must be closed in the correct order.
//
//  Note that an empty string is also considered valid.
//
//  Example 1:
//
//  Input: "()"
//  Output: true
//
//  Example 2:
//
//  Input: "()[]{}"
//  Output: true
//
//  Example 3:
//
//  Input: "(]"
//  Output: false
//
//  Example 4:
//
//  Input: "([)]"
//  Output: false
//
//  Example 5:
//
//  Input: "{[]}"
//  Output: true
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/valid-parentheses
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    ValidParentheses test = new ValidParentheses();
    System.out.println(test.isValid("[]"));
    System.out.println(test.isValid("()[]{}"));
    System.out.println(test.isValid("([)]"));
    System.out.println(test.isValid("{[()]}"));
  }

  public boolean isValid(String s) {
    if (s.length() == 0) {
      return true;
    }
    if (s.length() == 1 || !isLeft(s.charAt(0)) || s.length() % 2 != 0) {
      return false;
    }
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (isLeft(c)) {
        stack.push(c);
      } else if (stack.size() > 0 && turnAround(c) == stack.lastElement()) {
        stack.pop();
      } else {
        return false;
      }
    }
    return stack.size() == 0 ? true : false;
  }

  public boolean isLeft(char c) {
    if (c == '(' || c == '{' || c == '[') {
      return true;
    } else {
      return false;
    }
  }

  public char turnAround(char c) {
    if (c == '(') {
      return ')';
    }
    if (c == ')') {
      return '(';
    }
    if (c == '{') {
      return '}';
    }
    if (c == '}') {
      return '{';
    }
    if (c == '[') {
      return ']';
    }
    if (c == ']') {
      return '[';
    }
    return 0;
  }
}
