class No1049_LastStoneWeight2 {
//  We have a collection of rocks, each rock has a positive integer weight.
//
//  Each turn, we choose any two rocks and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
//
//      If x == y, both stones are totally destroyed;
//      If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
//
//  At the end, there is at most 1 stone left.  Return the smallest possible weight of this stone (the weight is 0 if there are no stones left.)
//
//   
//
//  Example 1:
//
//  Input: [2,7,4,1,8,1]
//  Output: 1
//  Explanation: 
//  We can combine 2 and 4 to get 2 so the array converts to [2,7,1,8,1] then,
//  we can combine 7 and 8 to get 1 so the array converts to [2,1,1,1] then,
//  we can combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
//  we can combine 1 and 1 to get 0 so the array converts to [1] then that's the optimal value.
//
//   
//
//  Note:
//
//      1 <= stones.length <= 30
//      1 <= stones[i] <= 100
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/last-stone-weight-ii
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No1049_LastStoneWeight2 test = new No1049_LastStoneWeight2();
    System.out.println(test.lastStoneWeightII(new int[] { 2, 7, 4, 1, 8 }));
    System.out.println(test.lastStoneWeightII(new int[] { 28, 7, 51, 47, 28, 54 }));
    System.out.println(test.lastStoneWeightII(new int[] { 36, 86, 8, 7 }));
  }

  public int lastStoneWeightII(int[] stones) {
    int len = stones.length;
    int sum = 0;
    for (int i = 0; i < len; i++) {
      sum += stones[i];
    }
    int half = sum / 2;
    int[][] p = new int[stones.length][half + 1];

    for (int i = 0; i < len; i++) {
      for (int j = 0; j < half + 1; j++) {
        int cur = j >= stones[i] ? stones[i] : 0;

        int top = i - 1 >= 0 ? p[i - 1][j] : 0;
        int pre = j - cur >= 0 && i - 1 >= 0 ? p[i - 1][j - cur] : 0;

        p[i][j] = Math.max(top, pre + cur);
//        p[i][j] = closest(j, top, pre, cur + top);
      }
    }
    return sum - 2 * p[len - 1][half];
  }
}
