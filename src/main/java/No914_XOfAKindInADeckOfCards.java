public class No914_XOfAKindInADeckOfCards {
//  In a deck of cards, each card has an integer written on it.
//
//  Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:
//
//      Each group has exactly X cards.
//      All the cards in each group have the same integer.
//
//   
//
//  Example 1:
//
//  Input: deck = [1,2,3,4,4,3,2,1]
//  Output: true
//  Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].
//
//  Example 2:
//
//  Input: deck = [1,1,1,2,2,2,3,3]
//  Output: false´
//  Explanation: No possible partition.
//
//  Example 3:
//
//  Input: deck = [1]
//  Output: false
//  Explanation: No possible partition.
//
//  Example 4:
//
//  Input: deck = [1,1]
//  Output: true
//  Explanation: Possible partition [1,1].
//
//  Example 5:
//
//  Input: deck = [1,1,2,2,2,2]
//  Output: true
//  Explanation: Possible partition [1,1],[2,2],[2,2].
//
//   
//
//  Constraints:
//
//      1 <= deck.length <= 10^4
//      0 <= deck[i] < 10^4
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  public static void main(String[] args) {
    No914_XOfAKindInADeckOfCards test = new No914_XOfAKindInADeckOfCards();
    System.out.println(test.hasGroupsSizeX(new int[] { 1, 2, 3, 4, 4, 3, 2, 1 }));
    System.out.println(test.hasGroupsSizeX(new int[] { 1, 1, 1, 2, 2, 2, 3, 3 }));
    System.out.println(test.hasGroupsSizeX(new int[] { 1 }));
    System.out.println(test.hasGroupsSizeX(new int[] { 1, 1 }));
    System.out.println(test.hasGroupsSizeX(new int[] { 1, 1, 2, 2, 2, 2 }));
  }

  public boolean hasGroupsSizeX(int[] deck) {
    if (deck == null || deck.length < 2) {
      return false;
    }
    int[] count = new int[10_000];
    for (int i : deck) {
      count[i]++;
    }
    int gcd = 0;
    for (int i : count) {
      if (i != 0) {
        if (gcd != 0 && gcd != i) {
          gcd = gcd(gcd, i);
          if (gcd < 2) {
            return false;
          }
        } else if (gcd == 0) {
          gcd = i;
        }
      }
    }
    return true;
  }

  int gcd(int i, int j) {
    if (j == 0) {
      return i;
    }
    return gcd(j, i % j);
  }
}
