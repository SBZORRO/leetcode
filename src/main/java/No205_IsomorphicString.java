import java.util.HashMap;
import java.util.Map;

public class No205_IsomorphicString {
//  Given two strings s and t, determine if they are isomorphic.
//
//  Two strings are isomorphic if the characters in s can be replaced to get t.
//
//  All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
//
//  Example 1:
//
//  Input: s = "egg", t = "add"
//  Output: true
//
//  Example 2:
//
//  Input: s = "foo", t = "bar"
//  Output: false
//
//  Example 3:
//
//  Input: s = "paper", t = "title"
//  Output: true
//
//  Note:
//  You may assume both s and t have the same length.
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/isomorphic-strings
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No205_IsomorphicString test = new No205_IsomorphicString();
    test.isIsomorphic("egg", "add");
  }

  public boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int[] sa = new int[128];
    int[] ta = new int[128];
    for (int i = 0; i < s.length(); i++) {
      int sc = s.charAt(i);
      int tc = t.charAt(i);
      if (sa[sc] != ta[tc]) {
        return false;
      }
      sa[sc] = i + 1;
      ta[tc] = i + 1;
    }
    return true;
  }

  public boolean isIsomorphic2(String s, String t) {

    if (s.length() != t.length()) {
      return false;
    }
    int[] sa = new int[128];
    int[] ta = new int[128];
    for (int i = 0; i < s.length(); i++) {
      int sc = s.charAt(i);
      int tc = t.charAt(i);
      if (sa[sc] != 0 && ta[tc] != 0) {
        if (sa[sc] != 0) {
          if (sa[sc] != tc) {
            return false;
          }
        }
        if (ta[tc] != 0) {
          if (ta[tc] != sc) {
            return false;
          }
        }
      } else if (sa[sc] == 0 && ta[tc] == 0) {
        sa[sc] = tc;
        ta[tc] = sc;
      } else {
        return false;
      }
    }
    return true;

  }

  public boolean isIsomorphic1(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    Map<Integer, Integer> ms = new HashMap<>();
    Map<Integer, Integer> mt = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      int sc = s.charAt(i);
      int tc = t.charAt(i);
      if (ms.containsKey(sc) && mt.containsKey(tc)) {
        if (ms.containsKey(sc)) {
          if (ms.get(sc) != tc) {
            return false;
          }
        }
        if (mt.containsKey(tc)) {
          if (mt.get(tc) != sc) {
            return false;
          }
        }
      } else if (!ms.containsKey(sc) && !mt.containsKey(tc)) {
        ms.put(sc, tc);
        mt.put(tc, sc);
      } else {
        return false;
      }

    }
    return true;
  }
}