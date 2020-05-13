import java.util.HashMap;
import java.util.Map;

public class No219_ContainsDuplicate2 {
//  Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
//
//      Example 1:
//
//      Input: nums = [1,2,3,1], k = 3
//      Output: true
//
//      Example 2:
//
//      Input: nums = [1,0,1,1], k = 1
//      Output: true
//
//      Example 3:
//
//      Input: nums = [1,2,3,1,2,3], k = 2
//      Output: false
//
//
//      来源：力扣（LeetCode）
//      链接：https://leetcode-cn.com/problems/contains-duplicate-ii
//      著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No219_ContainsDuplicate2 test = new No219_ContainsDuplicate2();

  }

  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
        return true;
      } else {
        map.put(nums[i], i);
      }
    }
    return false;
  }
}