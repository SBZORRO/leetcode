public class No76_MinimumWindowSubstring {
//  Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
//
//  Example:
//
//  Input: S = "ADOBECODEBANC", T = "ABC"
//  Output: "BANC"
//
//  Note:
//
//      If there is no such window in S that covers all characters in T, return the empty string "".
//      If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/minimum-window-substring
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No76_MinimumWindowSubstring test = new No76_MinimumWindowSubstring();
    test.minWindow("ADOBECODEBANC", "ABC");
    test.minWindow("aa", "aa");
    test.minWindow("lksdfghlkdbgliubliewry89yhgklsbdflkbvisugrlbebil;dsagfvhp;uetib", "kasdbhog");
    test.minWindow("lksdfghlkdbgliubliewdtghkdfg", "kasdbhog");
  }

  public String minWindow(String s, String t) {
    int[] ascii = new int[128];
    int[] counter = new int[128];

    for (int i = 0; i < t.length(); i++) {
      char c = t.charAt(i);
      ascii[c]++;
    }
    int min = Integer.MAX_VALUE;
    int beg = 0;
    int end = 0;
    int i = 0;
    int j = -1;
    char c = 0;
    int bits = t.length();

    while (i < s.length() && j <= i) {
      if (j >= 0) {
        c = s.charAt(j);
        if (counter[c] <= ascii[c]) {
          bits++;
        }
        counter[c]--;
      }
      if (++j >= s.length()) {
        return min == Integer.MAX_VALUE ? "" : s.substring(beg, end + 1);
      }
      c = s.charAt(j);
      while (ascii[c] == 0) {
        if (++j >= s.length()) {
          return min == Integer.MAX_VALUE ? "" : s.substring(beg, end + 1);
        }
        c = s.charAt(j);
      }

      if (i == 0) {
        i = j - 1;
      }

      while (bits != 0) {
        if (++i >= s.length()) {
          return min == Integer.MAX_VALUE ? "" : s.substring(beg, end + 1);
        }
        c = s.charAt(i);
        if (ascii[c] > 0) {
          if (counter[c] < ascii[c]) {
            bits--;
          }
          counter[c]++;
        }
      }
      if (min > i - j) {
        beg = j;
        end = i;
        min = i - j;
      }
    }
    return min == Integer.MAX_VALUE ? "" : s.substring(beg, end + 1);
  }

  // t中有重复字符 xor无效
  public String minWindow1(String s, String t) {
    int[] ascii = new int[128];
    int[] indi = new int[128];
    int[] counter = new int[128];
    int xor = 0;
    for (int i = 0; i < t.length(); i++) {
      char c = t.charAt(i);
      xor = xor ^ c;
      ascii[c]++;
      indi[c]++;
    }
    int min = Integer.MAX_VALUE;
    int beg = 0;
    int end = 0;
    int i = 0;
    int j = -1;
    char c = 0;
    while (i < s.length() && j <= i) {
      if (j >= 0) {
        c = s.charAt(j);
        if (counter[c] == 1) {
          xor = xor ^ c;
          indi[c] = 1;
        }
        counter[c]--;
      }
      if (++j >= s.length()) {
        return min == Integer.MAX_VALUE ? "" : s.substring(beg, end + 1);
      }
      c = s.charAt(j);
      while (ascii[c] == 0) {
        if (++j >= s.length()) {
          return min == Integer.MAX_VALUE ? "" : s.substring(beg, end + 1);
        }
        c = s.charAt(j);
      }

      if (i == 0) {
        i = j - 1;
      }
//      xor = xor ^ c;
      while (xor != 0) {
        if (++i >= s.length()) {
          return min == Integer.MAX_VALUE ? "" : s.substring(beg, end + 1);
        }
        c = s.charAt(i);
        if (ascii[c] > 0) {
          counter[c]++;
          if (indi[c] > 0) {
            xor = xor ^ c;
            indi[c] = 0;
          }
        }
      }
      if (min > i - j) {
        beg = j;
        end = i;
        min = i - j;
      }
    }
    return min == Integer.MAX_VALUE ? "" : s.substring(beg, end + 1);
  }
}
