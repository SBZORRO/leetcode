class No466_CountTheRepetitions {
//  Define S = [s,n] as the string S which consists of n connected strings s. For example, ["abc", 3] ="abcabcabc".
//
//      On the other hand, we define that string s1 can be obtained from string s2 if we can remove some characters from s2 such that it becomes s1. For example, “abc” can be obtained from “abdbec” based on our definition, but it can not be obtained from “acbbe”.
//
//      You are given two non-empty strings s1 and s2 (each at most 100 characters long) and two integers 0 ≤ n1 ≤ 106 and 1 ≤ n2 ≤ 106. Now consider the strings S1 and S2, where S1=[s1,n1] and S2=[s2,n2]. Find the maximum integer M such that [S2,M] can be obtained from S1.
//
//      Example:
//
//      Input:
//      s1="acb", n1=4
//      s2="ab", n2=2
//
//      Return:
//      2
//
//      来源：力扣（LeetCode）
//      链接：https://leetcode-cn.com/problems/count-the-repetitions
//      著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No466_CountTheRepetitions test = new No466_CountTheRepetitions();

    System.out.print(test.getMaxRepetitions("abc", 4, "bca", 2));
  }

//  public int subseq(String s1, String s2) {
//
//  }

  public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
    int maxlen1 = s1.length() * n1;
    int maxlen2 = s2.length() * n2;

    if (maxlen2 > maxlen1) {
      return 0;
    } else {
      int count1 = 0;
      int count2 = 0;
      int round = 0;
      int dejavu = -1;
      for (int i = 0, j = 0;;) {
        if (count1 > 0 && count2 > 0) {
          int tominor = 0;
          if (i == 0) {
            tominor = j;
          }
          if (j == 0) {
            tominor = i;
          }
          int temp = count1 * s1.length() - count2 * s2.length() - tominor;
          if (round == 0) {
            dejavu = temp;
            round = 1;
          } else if (round == 1 && dejavu == temp) {
            break;
          }
          count1 = 0;
          count2 = 0;
        }
        if (n1 == 0) {
          break;
        }
        if (n2 == 0) {
          break;
        }
        if (s1.charAt(i) == s2.charAt(j)) {
          i++;
          j++;
        } else {
          i++;
        }
        if (i == s1.length()) {
          i = 0;
          n1--;
          count1++;
        }
        if (j == s2.length()) {
          j = 0;
          n2--;
          count2++;
        }

      }
    }
    return 1;
  }
}
