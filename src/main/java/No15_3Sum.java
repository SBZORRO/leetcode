import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class No15_3Sum {
//  Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
//      Note:
//
//      The solution set must not contain duplicate triplets.
//
//      Example:
//
//      Given array nums = [-1, 0, 1, 2, -1, -4],
//
//      A solution set is:
//      [
//        [-1, 0, 1],
//        [-1, -1, 2]
//      ]
//
//
//      来源：力扣（LeetCode）
//      链接：https://leetcode-cn.com/problems/3sum
//      著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  public static void main(String[] args) {
    No15_3Sum test = new No15_3Sum();
    test.threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
  }

  public List<List<Integer>> threeSum(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        map.put(nums[i], map.get(nums[i]) + 1);
      } else {
        map.put(nums[i], 1);
      }
    }
    Arrays.sort(nums);
    List<List<Integer>> lis = new LinkedList<>();
    for (int i = 0; i < nums.length - 1; i++) {
      if (i > 0 && nums[i - 1] == nums[i]) {
        continue;
      }
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j - 1] == nums[j]) {
          if (i != j - 1) {
            continue;
          }
        }
        int tar = 0 - (nums[i] + nums[j]);
        if (map.containsKey(tar)) {
          if (tar < nums[j]) {
            continue;
          } else if (tar == nums[j]) {
            int n = map.get(tar);
            if ((tar == nums[i] && n >= 3) || (tar != nums[i] && n >= 2)) {
              List<Integer> li = new LinkedList<Integer>();
              li.add(tar);
              li.add(nums[i]);
              li.add(nums[j]);
              lis.add(li);
            }
          } else {
            List<Integer> li = new LinkedList<Integer>();
            li.add(tar);
            li.add(nums[i]);
            li.add(nums[j]);
            lis.add(li);
          }
        }
      }
    }
    return lis;
  }
}
