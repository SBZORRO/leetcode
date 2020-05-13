import java.util.HashMap;
import java.util.Map;

public class No217_ContainsDuplicate {
//  Given an array of integers, find if the array contains any duplicates.
//
//  Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
//
//  Example 1:
//
//  Input: [1,2,3,1]
//  Output: true
//
//  Example 2:
//
//  Input: [1,2,3,4]
//  Output: false
//
//  Example 3:
//
//  Input: [1,1,1,3,3,4,3,2,4,2]
//  Output: true
//
//
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/contains-duplicate
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No217_ContainsDuplicate test = new No217_ContainsDuplicate();

  }

  public boolean containsDuplicate(int[] nums) {
    if (nums == null || nums.length == 0) {
      return false;
    }
    Map<Integer, Integer> map = new HashMap<>(nums.length);
    for (int i : nums) {
      if (map.containsKey(i)) {
        return true;
      } else {
        map.put(i, i);
      }
    }
    return false;
  }
}