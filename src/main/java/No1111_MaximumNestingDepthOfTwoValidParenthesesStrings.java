public class No1111_MaximumNestingDepthOfTwoValidParenthesesStrings {
//  A string is a valid parentheses string (denoted VPS) if and only if it consists of "(" and ")" characters only, and:
//
//    It is the empty string, or
//    It can be written as AB (A concatenated with B), where A and B are VPS's, or
//    It can be written as (A), where A is a VPS.
//
//We can similarly define the nesting depth depth(S) of any VPS S as follows:
//
//    depth("") = 0
//    depth(A + B) = max(depth(A), depth(B)), where A and B are VPS's
//    depth("(" + A + ")") = 1 + depth(A), where A is a VPS.
//
//For example,  "", "()()", and "()(()())" are VPS's (with nesting depths 0, 1, and 2), and ")(" and "(()" are not VPS's.
//
// 
//
//Given a VPS seq, split it into two disjoint subsequences A and B, such that A and B are VPS's (and A.length + B.length = seq.length).
//
//Now choose any such A and B such that max(depth(A), depth(B)) is the minimum possible value.
//
//Return an answer array (of length seq.length) that encodes such a choice of A and B:  answer[i] = 0 if seq[i] is part of A, else answer[i] = 1.  Note that even though multiple answers may exist, you may return any of them.
//
// 
//
//Example 1:
//
//Input: seq = "(()())"
//Output: [0,1,1,1,1,0]
//
//Example 2:
//
//Input: seq = "()(())()"
//Output: [0,0,0,1,1,0,1,1]
//
// 
//
//Constraints:
//
//    1 <= seq.size <= 10000
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  /*
   * 简单来说就是按顺序给括号分组. 使得两组括号深度最小.
   * 不要求成对分组, 比如(()), 完全可以02一组13一组, 或者按直觉12一组03一组.
   */
  public static void main(String[] args) {
    No1111_MaximumNestingDepthOfTwoValidParenthesesStrings test = new No1111_MaximumNestingDepthOfTwoValidParenthesesStrings();
    System.out.println(test.maxDepthAfterSplit("(()())"));
    System.out.println(test.maxDepthAfterSplit("()(())()"));
  }

  public int[] maxDepthAfterSplit(String seq) {
    int[] result = new int[seq.length()];
    int depth = 1;
    for (int i = 0; i < seq.length(); i++) {
      char c = seq.charAt(i);
      if ('(' == c) {
        result[i] = depth % 2;
        depth++;
      } else if (')' == c) {
        depth--;
        result[i] = depth % 2;
      }
    }
    return result;
  }
}
