public class No242_ValidAnagram {
//  Given two strings s and t , write a function to determine if t is an anagram of s.
//
//  Example 1:
//
//  Input: s = "anagram", t = "nagaram"
//  Output: true
//
//  Example 2:
//
//  Input: s = "rat", t = "car"
//  Output: false
//
//  Note:
//  You may assume the string contains only lowercase alphabets.
//
//  Follow up:
//  What if the inputs contain unicode characters? How would you adapt your solution to such case?
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/valid-anagram
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No242_ValidAnagram test = new No242_ValidAnagram();
  }

  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int[] a1 = new int[26];
    int[] a2 = new int[26];
    for (char c : s.toCharArray()) {
      a1[c - 'a']++;
    }
    for (char c : t.toCharArray()) {
      a2[c - 'a']++;
    }
    for (int i = 0; i < a1.length; i++) {
      if (a1[i] != a2[i]) {
        return false;
      }
    }
    return true;
  }
}
