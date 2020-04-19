public class No72_EditDistance {
//  Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
//
//  You have the following 3 operations permitted on a word:
//
//      Insert a character
//      Delete a character
//      Replace a character
//
//  Example 1:
//
//  Input: word1 = "horse", word2 = "ros"
//  Output: 3
//  Explanation: 
//  horse -> rorse (replace 'h' with 'r')
//  rorse -> rose (remove 'r')
//  rose -> ros (remove 'e')
//
//  Example 2:
//
//  Input: word1 = "intention", word2 = "execution"
//  Output: 5
//  Explanation: 
//  intention -> inention (remove 't')
//  inention -> enention (replace 'i' with 'e')
//  enention -> exention (replace 'n' with 'x')
//  exention -> exection (replace 'n' with 'c')
//  exection -> execution (insert 
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/edit-distance
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No72_EditDistance test = new No72_EditDistance();
    int i = 0;
    System.out.println(i++);
    System.out.println(++i);

  }

  public int minDistance(String word1, String word2) {
    char[] a = new char[word1.length()];
    char[] b = new char[word2.length()];
    for (int i = 0; i < word1.length(); i++) {
      for (int j = 0; j < word2.length(); j++) {
        if (a[i] == b[j]) {
          while (true) {
            if (a[++i] == b[++j]) {

            }
          }
        }
      }
    }
  }
}
