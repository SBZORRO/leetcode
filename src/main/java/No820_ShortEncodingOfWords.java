public class No820_ShortEncodingOfWords {
//  Given a list of words, we may encode it by writing a reference string S and a list of indexes A.
//
//  For example, if the list of words is ["time", "me", "bell"], we can write it as S = "time#bell#" and indexes = [0, 2, 5].
//
//  Then for each index, we will recover the word by reading from the reference string from that index until we reach a "#" character.
//
//  What is the length of the shortest reference string S possible that encodes the given words?
//
//  Example:
//
//  Input: words = ["time", "me", "bell"]
//  Output: 10
//  Explanation: S = "time#bell#" and indexes = [0, 2, 5].
//
//   
//
//  Note:
//
//      1 <= words.length <= 2000.
//      1 <= words[i].length <= 7.
//      Each word has only lowercase letters.
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/short-encoding-of-words
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  public static void main(String[] args) {
    No820_ShortEncodingOfWords test = new No820_ShortEncodingOfWords();
    System.out.println(test.minimumLengthEncoding(new String[] { "time", "me", "bell" }));
    System.out.println(test.minimumLengthEncoding(new String[] { "me", "time" }));
    System.out.println(test.minimumLengthEncoding(new String[] { "time", "time", "time", "time" }));
  }

  public int minimumLengthEncoding(String[] words) {
    if (words == null || words.length == 0) {
      return 0;
    }
    if (words.length == 1) {
      return words[0].length() + 1;
    }
    int[] mark = new int[words.length];
    int result = 0;
    int plusOne = 0;
    for (int i = 0; i < words.length; i++) {
      for (int j = 0; j < words.length; j++) {
        if (i != j && mark[i] == 0 && words[i].endsWith(words[j])) {
          mark[j]++;
        }
      }
    }
    for (int i = 0; i < words.length; i++) {
      if (mark[i] == 0) {
        result += words[i].length();
        plusOne++;
      }
    }
    return result + plusOne;
  }
}
