class No3_LongestCommonPrefix {
//  Write a function to find the longest common prefix string amongst an array of strings.
//
//  If there is no common prefix, return an empty string "".
//
//  Example 1:
//
//  Input: ["flower","flow","flight"]
//  Output: "fl"
//
//  Example 2:
//
//  Input: ["dog","racecar","car"]
//  Output: ""
//  Explanation: There is no common prefix among the input strings.
//
//  Note:
//
//  All given inputs are in lowercase letters a-z.
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/longest-common-prefix
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No3_LongestCommonPrefix test = new No3_LongestCommonPrefix();
    System.out.println(test.longestCommonPrefix(new String[] { "lkj", "lkjf", "lkff" }));
    System.out.println(test.longestCommonPrefix(new String[] { "abca", "abca", "abca" }));
  }

  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) {
      return "";
    }
    String target = strs[0];
    for (String s : strs) {
      while (true) {
        if (target.length() == 0 || s.length() == 0) {
          return "";
        }
        if (s.length() < target.length()) {
          target = target.substring(0, s.length());
        }
        if (!target.equals(s.substring(0, target.length()))) {
          target = target.substring(0, target.length() - 1);
        } else {
          break;
        }
      }
    }
    return target;
  }

  public String longestCommonPrefix2(String[] strs) {
    if (strs.length == 0) {
      return "";
    }
    String target = strs[0];

    String result = "";
    for (int i = 0; i < target.length(); i++) {
      char c = target.charAt(i);

      for (String s : strs) {
        if (s.length() == i) {
          return result;
        }

        if (c != s.charAt(i)) {
          return result;
        }
      }
      result = result + c;
    }
    return result;
  }

  public String longestCommonPrefix1(String[] strs) {
    if (strs.length == 0) {
      return "";
    }
    String result = "";
    for (int i = 0;; i++) {
      if (strs[0].length() == i) {
        return result;
      }
      char c = strs[0].charAt(i);

      for (String s : strs) {
        if (s.length() == i) {
          return result;
        }

        if (c != s.charAt(i)) {
          return result;
        }
      }
      result = result + c;
    }
  }
}
