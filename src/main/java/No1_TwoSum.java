

import java.util.HashMap;

class No1_TwoSum {
//  Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//
//      You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//      Example:
//
//      Given nums = [2, 7, 11, 15], target = 9,
//
//      Because nums[0] + nums[1] = 2 + 7 = 9,
//      return [0, 1].
//
//      来源：力扣（LeetCode）
//      链接：https://leetcode-cn.com/problems/two-sum
//      著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No1_TwoSum ts = new No1_TwoSum();
    int[] arr = ts.twoSum(new int[] { 2, 7, 11, 15 }, 9);

    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);

      System.out.println("\n");
    }
  }

  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      if (!map.containsKey(nums[i])) {
        map.put(target - nums[i], i);
      } else {
        int[] pos = new int[2];
        pos[0] = map.get(nums[i]);
        pos[1] = i;
        return pos;
      }
    }
    return null;
  }
}
