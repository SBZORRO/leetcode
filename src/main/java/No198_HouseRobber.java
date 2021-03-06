public class No198_HouseRobber {
//  You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
//
//  Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
//
//  Example 1:
//
//  Input: [1,2,3,1]
//  Output: 4
//  Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//               Total amount you can rob = 1 + 3 = 4.
//
//  Example 2:
//
//  Input: [2,7,9,3,1]
//  Output: 12
//  Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
//               Total amount you can rob = 2 + 9 + 1 = 12.
//
//
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/house-robber
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No198_HouseRobber test = new No198_HouseRobber();
//    test.rob(new int[] { 1, 2, 3, 1 });
    System.out.println(test.rob(new int[] { 1, 3, 1, 3, 100 }));
  }

  public int rob(int[] nums) {
    int max = 0;
    int pm = 0;
    for (int i = 0; i < nums.length; i++) {
      int tmp = max;
      max = Math.max(pm + nums[i], max);
      pm = tmp;
    }
    return max;
  }
}