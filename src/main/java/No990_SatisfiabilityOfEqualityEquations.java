import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class No990_SatisfiabilityOfEqualityEquations {
//  Given an array equations of strings that represent relationships between variables, each string equations[i] has length 4 and takes one of two different forms: "a==b" or "a!=b".  Here, a and b are lowercase letters (not necessarily different) that represent one-letter variable names.
//
//  Return true if and only if it is possible to assign integers to variable names so as to satisfy all the given equations.
//
//   
//
//  Example 1:
//
//  Input: ["a==b","b!=a"]
//  Output: false
//  Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.  There is no way to assign the variables to satisfy both equations.
//
//  Example 2:
//
//  Input: ["b==a","a==b"]
//  Output: true
//  Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
//
//  Example 3:
//
//  Input: ["a==b","b==c","a==c"]
//  Output: true
//
//  Example 4:
//
//  Input: ["a==b","b!=c","c==a"]
//  Output: false
//
//  Example 5:
//
//  Input: ["c==c","b==d","x!=z"]
//  Output: true
//
//   
//
//  Note:
//
//      1 <= equations.length <= 500
//      equations[i].length == 4
//      equations[i][0] and equations[i][3] are lowercase letters
//      equations[i][1] is either '=' or '!'
//      equations[i][2] is '='
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/satisfiability-of-equality-equations
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No990_SatisfiabilityOfEqualityEquations test = new No990_SatisfiabilityOfEqualityEquations();
//    test.equationsPossible(new String[] { "a==b", "e==c", "b==c", "a!=e" });
    test.equationsPossible(new String[] { "a!=f", "c!=a", "a!=d", "a==d", "f==c", "a!=c" });
  }

  public boolean equationsPossible(String[] equations) {
    if (equations == null || equations.length == 0) {
      return true;
    }
    Map<Character, Object[]> ds = new HashMap<>();
    Set<char[]> disjoint = new HashSet<>();
    for (int i = 0; i < equations.length; i++) {
      char a = equations[i].charAt(0);
      char b = equations[i].charAt(3);
      if (equations[i].charAt(1) == '=') {
        if (ds.containsKey(a) && ds.containsKey(b)) {
          Set<Character> seta = (Set<Character>) ds.get(a)[0];
          Set<Character> setb = (Set<Character>) ds.get(b)[0];
          seta.addAll(setb);
          ds.get(b)[0] = seta;
        } else if (!ds.containsKey(a) && !ds.containsKey(b)) {
          Object[] p = new Object[1];
          Set<Character> set = new HashSet<Character>();
          set.add(a);
          set.add(b);
          p[0] = set;
          ds.put(a, p);
          ds.put(b, p);
        } else if (ds.containsKey(a) && !ds.containsKey(b)) {
          Object[] p = ds.get(a);
          Set<Character> seta = (Set<Character>) ds.get(a)[0];
          seta.add(b);
          ds.put(b, p);
        } else if (ds.containsKey(b) && !ds.containsKey(a)) {
          Object[] p = ds.get(b);
          Set<Character> setb = (Set<Character>) ds.get(b)[0];
          setb.add(a);
          ds.put(a, p);
        }
      } else {
        if (a == b) {
          return false;
        }
        char[] entry = new char[] { a, b };
        disjoint.add(entry);
      }
    }
    if (ds.size() == 0) {
      return true;
    }
    for (char[] entry : disjoint) {
      if ((ds.containsKey(entry[0]) && ds.containsKey(entry[1]))
          && ds.get(entry[0])[0] == ds.get(entry[1])[0]) {
        return false;
      }
    }
    return true;
  }
}
