import java.util.HashMap;

public class No1160_FindWordsThatCanBeFormedByCharacters {
//  You are given an array of strings words and a string chars.
//
//  A string is good if it can be formed by characters from chars (each character can only be used once).
//
//  Return the sum of lengths of all good strings in words.
//
//   
//
//  Example 1:
//
//  Input: words = ["cat","bt","hat","tree"], chars = "atach"
//  Output: 6
//  Explanation: 
//  The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
//
//  Example 2:
//
//  Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
//  Output: 10
//  Explanation: 
//  The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
//
//   
//
//  Note:
//
//      1 <= words.length <= 1000
//      1 <= words[i].length, chars.length <= 100
//      All strings contain lowercase English letters only.
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No1160_FindWordsThatCanBeFormedByCharacters test = new No1160_FindWordsThatCanBeFormedByCharacters();
    System.out.println(
        test.countCharacters(
            new String[] { "ahasd", "dfj", "as", "ndsdrth" },
            "sfdjtgukyjfdbqwxcvhbfg"));

    System.out.println(
        test.countCharacters(
            new String[] { "xzcfhwrth", "asheryasd", "adfhaedr" },
            "sfdjefyjyhilsdrhfgwbxcjmdfy"));
  }

  public int countCharacters(String[] words, String chars) {

    if (words == null || words.length == 0 || chars == null || chars.length() == 0)

    {
      return 0;
    }
    int result = 0;
    int[] dict = new int[26];
    boolean add = true;
    for (char c : chars.toCharArray()) {
      dict[c - 'a']++;
    }

    for (String s : words) {
      if (s == null || s.length() == 0) {
        break;
      }
      int[] word = new int[26];
      for (char c : s.toCharArray()) {
        if (dict[c - 'a'] == word[c - 'a']) {
          add = false;
          break;
        }
        word[c - 'a']++;
      }

      if (add) {
        result += s.length();
      }
      add = true;
    }
    return result;
  }

  public int countCharacters3(String[] words, String chars) {
    if (words == null || words.length == 0 || chars == null || chars.length() == 0) {
      return 0;
    }
    int result = 0;
    int[] dict = new int[26];
    boolean add = true;
    for (char c : chars.toCharArray()) {
      dict[c - 'a']++;
    }

    for (String s : words) {
      if (s == null || s.length() == 0) {
        break;
      }
      int[] word = new int[26];
      for (char c : s.toCharArray()) {
        word[c - 'a']++;
        if (dict[c - 'a'] < word[c - 'a']) {
          add = false;
          break;
        }
      }

      if (add) {
        result += s.length();
      }
      add = true;
    }
    return result;
  }

  public int countCharacters2(String[] words, String chars) {
    if (words == null || words.length == 0 || chars == null || chars.length() == 0) {
      return 0;
    }
    int result = 0;
    HashMap<Character, Integer> word = new HashMap<>();
    int[] dict = new int[26];
    boolean add = true;
    for (char c : chars.toCharArray()) {
      dict[c - 'a']++;
    }
    int i = 0;
    for (String s : words) {
      word.clear();
      if (s == null || s.length() == 0) {
        break;
      }
      for (char c : s.toCharArray()) {
        i = 0;
        if (word.containsKey(c)) {
          i = word.get(c);
        }
        word.put(c, ++i);
        if (dict[c - 'a'] < i) {
          add = false;
          break;
        }
      }

      if (add) {
        result += s.length();
      }
      add = true;
    }
    return result;
  }

  public int countCharacters1(String[] words, String chars) {
    if (words == null || words.length == 0 || chars == null || chars.length() == 0) {
      return 0;
    }
    int result = 0;
    HashMap<Character, Integer> map = new HashMap<>();
    for (String s : words) {
      map.clear();
      if (s == null || s.length() == 0) {
        break;
      }
      for (char c : s.toCharArray()) {
        int i = 0;
        if (map.containsKey(c)) {
          i = map.get(c);
        }
        map.put(c, ++i);
      }
      for (char c : chars.toCharArray()) {
        if (map.isEmpty()) {
          break;
        }
        if (map.containsKey(c)) {
          int i = 0;
          i = map.get(c);
          if (i == 1) {
            map.remove(c);
          } else {
            map.put(c, --i);
          }
        }
      }
      if (map.isEmpty()) {
        result += s.length();
      }
    }
    return result;
  }
}
