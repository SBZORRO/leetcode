class No55_JumpGame {
//  Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//  Each element in the array represents your maximum jump length at that position.
//
//  Determine if you are able to reach the last index.
//
//  Example 1:
//
//  Input: [2,3,1,1,4]
//  Output: true
//  Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
//
//  Example 2:
//
//  Input: [3,2,1,0,4]
//  Output: false
//  Explanation: You will always arrive at index 3 no matter what. Its maximum
//               jump length is 0, which makes it impossible to reach the last index.
//
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/jump-game
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No55_JumpGame test = new No55_JumpGame();
    System.out.println(test.canJump(new int[] { 2, 3, 1, 1, 4 }));
    System.out.println(test.canJump(new int[] { 3, 2, 1, 0, 4 }));
    System.out.println(test.canJump(new int[] { 2, 5, 0, 0 }));
    System.out.println(test.canJump(new int[] { 5, 4, 0, 2, 0, 1, 0, 1, 0 }));
  }

  public boolean canJump(int[] nums) {
    if (nums == null || nums.length == 0) {
      return false;
    }
    if (nums.length == 1) {
      return true;
    }
    int gap = 0;
    int i = nums.length - 2;
    while (i >= 0) {
      gap = 0;
      while (i >= 0 && nums[i] <= gap) {
        gap++;
        i--;
      }
      if (gap == 0) {
        i--;
      }
    }
    return gap == 0 ? true : false;
  }
}
