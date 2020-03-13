import java.util.HashMap;

public class No3_LongestSubstringWithoutRepeatingCharacters {
//  Given a string, find the length of the longest substring without repeating characters.
//
//  Example 1:
//
//  Input: "abcabcbb"
//  Output: 3 
//  Explanation: The answer is "abc", with the length of 3. 
//
//  Example 2:
//
//  Input: "bbbbb"
//  Output: 1
//  Explanation: The answer is "b", with the length of 1.
//
//  Example 3:
//
//  Input: "pwwkew"
//  Output: 3
//  Explanation: The answer is "wke", with the length of 3. 
//               Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
//
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No3_LongestSubstringWithoutRepeatingCharacters cc = new No3_LongestSubstringWithoutRepeatingCharacters();
    System.out.println(cc.lengthOfLongestSubstring("tmmzuxt"));

  }

  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    if (s.length() == 1) {
      return 1;
    }
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    int max = 0;
    int beg = 0;

    char[] arr = s.toCharArray();
    for (int i = 0; i < arr.length; i++) {

      if (!map.containsKey(arr[i])) {
        map.put(arr[i], i);
        max = Math.max(max, i - beg + 1);
      } else {
        if (map.get(arr[i]) >= beg) {
          beg = map.get(arr[i]) + 1;
        } else {
          max = Math.max(max, i - beg + 1);
        }
        map.put(arr[i], i);
      }
    }

    return max;
  }
}