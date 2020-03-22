public class No945_MinimumIncrementToMakeArrayUnique {
//  Given an array of integers A, a move consists of choosing any A[i], and incrementing it by 1.
//
//  Return the least number of moves to make every value in A unique.
//
//   
//
//  Example 1:
//
//  Input: [1,2,2]
//  Output: 1
//  Explanation:  After 1 move, the array could be [1, 2, 3].
//
//  Example 2:
//
//  Input: [3,2,1,2,1,7]
//  Output: 6
//  Explanation:  After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
//  It can be shown with 5 or less moves that it is impossible for the array to have all unique values.
//
//   
//
//  Note:
//
//      0 <= A.length <= 40000
//      0 <= A[i] < 40000
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  public static void main(String[] args) {
    No945_MinimumIncrementToMakeArrayUnique test = new No945_MinimumIncrementToMakeArrayUnique();
    System.out.println(test.minIncrementForUnique(new int[] { 1, 2, 2 }));
    System.out.println(test.minIncrementForUnique(new int[] { 3, 2, 1, 2, 1, 7 }));
    System.out.println(test.minIncrementForUnique(new int[] { 0, 0 }));
    System.out.println(test.minIncrementForUnique(new int[] { 2, 2, 2, 2, 0 }));

  }

//  作者：LeetCode-Solution
//  链接：https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/solution/shi-shu-zu-wei-yi-de-zui-xiao-zeng-liang-by-leet-2/
//  来源：力扣（LeetCode）
//  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
  public int minIncrementForUnique(int[] A) {
    int[] count = new int[80000];
    for (int x : A)
      count[x]++;

    int ans = 0, taken = 0;

    for (int x = 0; x < 80000; ++x) {
      if (count[x] >= 2) {
        taken += count[x] - 1;
        ans -= x * (count[x] - 1);
      } else if (taken > 0 && count[x] == 0) {
        taken--;
        ans += x;
      }
    }

    return ans;
  }

  public int minIncrementForUnique3(int[] A) {
    int[] fortyK = new int[80_002];
    int result = 0;
    int last = 0;
    for (int i : A) {
      fortyK[i] = fortyK[i] + 1;
    }
    for (int i : fortyK) {
      if (i >= 2) {
        last += i - 1;
        result += last;

      } else if (i == 1) {
        result += last;
      } else if (i == 0 && last != 0) {
        last--;
        result += last;

      }
    }
    return result + last;
  }

  public int minIncrementForUnique2(int[] A) {
    int[] fortyK = new int[80_002];
    int result = 0;
    for (int i : A) {
      int count = iter(fortyK, i);
      result = result + count;
      if (count != 0)
        fortyK[i] = count;

    }
    return result;
  }

  public int iter(int[] fortyK, int i) {
    if (fortyK[i] == 0) {
      fortyK[i] = 1;
      return 0;
    }
    return fortyK[i] + iter(fortyK, i + fortyK[i]);
  }

  public int minIncrementForUnique1(int[] A) {

    int[] fortyK = new int[80_002];
    int result = 0;
    fortyK[0] = -1;
    for (int i : A) {
      if (fortyK[i] == 0 && i != 0) {
        fortyK[i] = i;
      } else if (fortyK[0] != 0 && i == 0) {
        fortyK[0] = 0;
      } else {
        while (true) {
          i++;
          result++;
          if (fortyK[i] == 0) {
            fortyK[i] = i;
            break;
          }
        }
      }
    }
    return result;

  }

}
