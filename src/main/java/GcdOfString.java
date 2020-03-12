public class GcdOfString {
//  For strings S and T, we say "T divides S" if and only if S = T + ... + T  (T concatenated with itself 1 or more times)
//
//  Return the largest string X such that X divides str1 and X divides str2.
//
//   
//
//  Example 1:
//
//  Input: str1 = "ABCABC", str2 = "ABC"
//  Output: "ABC"
//
//  Example 2:
//
//  Input: str1 = "ABABAB", str2 = "ABAB"
//  Output: "AB"
//
//  Example 3:
//
//  Input: str1 = "LEET", str2 = "CODE"
//  Output: ""
//
//   
//
//  Note:
//
//      1 <= str1.length <= 1000
//      1 <= str2.length <= 1000
//      str1[i] and str2[i] are English uppercase letter
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/greatest-common-divisor-of-strings
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    GcdOfString test = new GcdOfString();
    System.out.println(test.gcdOfStrings("ABCAasdBC", "ABC"));
//    System.out.println(test.isValid("()[]{}"));
//    System.out.println(test.isValid("([)]"));
//    System.out.println(test.isValid("{[()]}"));
  }

  public String gcdOfStrings(String str1, String str2) {
    if (str1 == null || str2 == null || "".equals(str1) || "".equals(str2)) {
      return "";
    }
    int len1 = str1.length();
    int len2 = str2.length();
    if (str1.length() == str2.length() && str1.equals(str2)) {
      return str1;
    }
    
    String temp = "";
        String longer = "";
    String shorter = "";

    if (len1 > len2) {
      temp= str1.substring(0, len2);
      shorter = str1.substring(len2);
      longer = str2;
          } else {
      temp= str2.substring(0, len1);
      shorter = str2.substring(len1);
      longer = str1;
      }
    
    if (!temp.equals(longer)) {
      return "";
    }

    return gcdOfStrings(longer, shorter);
  }

  }
