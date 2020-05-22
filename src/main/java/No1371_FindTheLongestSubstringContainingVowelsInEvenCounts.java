import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No1371_FindTheLongestSubstringContainingVowelsInEvenCounts {
//  Given the string s, return the size of the longest substring containing each vowel an even number of times. That is, 'a', 'e', 'i', 'o', and 'u' must appear an even number of times.
//
//      
//
//      Example 1:
//
//      Input: s = "eleetminicoworoep"
//      Output: 13
//      Explanation: The longest substring is "leetminicowor" which contains two each of the vowels: e, i and o and zero of the vowels: a and u.
//
//      Example 2:
//
//      Input: s = "leetcodeisgreat"
//      Output: 5
//      Explanation: The longest substring is "leetc" which contains two e's.
//
//      Example 3:
//
//      Input: s = "bcbcbc"
//      Output: 6
//      Explanation: In this case, the given string "bcbcbc" is the longest because all vowels: a, e, i, o and u appear zero times.
//
//       
//
//      Constraints:
//
//          1 <= s.length <= 5 x 10^5
//          s contains only lowercase English letters.
//
//      来源：力扣（LeetCode）
//      链接：https://leetcode-cn.com/problems/find-the-longest-substring-containing-vowels-in-even-counts
//      著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No1371_FindTheLongestSubstringContainingVowelsInEvenCounts test = new No1371_FindTheLongestSubstringContainingVowelsInEvenCounts();
    test.findTheLongestSubstring("eleetminicoworoep");
    test.findTheLongestSubstring("leetcodeisgreat");
    test.findTheLongestSubstring("id");
  }

  public int findTheLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    int[] a = new int[32];
    Arrays.fill(a, -1);
    int vowel = 0;
    int max = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == 'a') {
        vowel = vowel ^ 16;
      } else if (c == 'e') {
        vowel = vowel ^ 8;
      } else if (c == 'i') {
        vowel = vowel ^ 4;
      } else if (c == 'o') {
        vowel = vowel ^ 2;
      } else if (c == 'u') {
        vowel = vowel ^ 1;
      } else if (i == 0) {
        a[vowel] = i;
      }
      if (a[vowel] == -1) {
        a[vowel] = i;
      } else {
        if (vowel == 0) {
          max = Math.max(max, i + 1);
        } else {
          max = Math.max(max, i - a[vowel]);
        }
      }
    }
    return max;
  }

  public int findTheLongestSubstring1(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    Map<Character, Boolean> map = new HashMap<Character, Boolean>() {
      {
        put('a', true);
        put('e', true);
        put('i', true);
        put('o', true);
        put('u', true);
      }
    };
    int max = 0;
    boolean isEven = true;
    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j < s.length(); j++) {
        if (map.containsKey(s.charAt(j))) {
          boolean tmp = map.get(s.charAt(j));
          map.put(s.charAt(j), !tmp);
          if (tmp == false) {
            if (map.get('a') && map.get('e') && map.get('i') && map.get('o') && map.get('u')) {
              max = Math.max(max, j - i + 1);
              isEven = true;
            }
          } else {
            isEven = false;
          }
        } else if (isEven) {
          max = Math.max(max, j - i + 1);
        }
      }
      map.put('a', true);
      map.put('e', true);
      map.put('i', true);
      map.put('o', true);
      map.put('u', true);
      isEven = true;
    }
    return max;
  }
}
