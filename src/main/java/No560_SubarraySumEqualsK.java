import java.util.HashMap;
import java.util.Map;

public class No560_SubarraySumEqualsK {
//  Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
//
//  Example 1:
//
//  Input:nums = [1,1,1], k = 2
//  Output: 2
//
//   
//
//  Constraints:
//
//      The length of the array is in range [1, 20,000].
//      The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
//
//
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No560_SubarraySumEqualsK test = new No560_SubarraySumEqualsK();
    test.subarraySum(new int[] { 1, -1, 1, -1, 1, -1 }, 0);
    test.subarraySum(new int[] { 1, 1, 1 }, 2);
  }

  public int subarraySum(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int sum = 0;
    int res = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (sum == k) {
        res++;
      }
      if (map.containsKey(sum - k)) {
        res += map.get(sum - k);
      }
      if (map.containsKey(sum)) {
        map.put(sum, map.get(sum) + 1);
      } else {
        map.put(sum, 1);
      }

    }
    return res;
  }

  public int subarraySum1(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int sum = 0;
    int res = 0;
    int[] p = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      p[i] = sum;
      if (sum == k) {
        res++;
      }
    }
    for (int i = 0; i < nums.length; i++) {
      int cur = nums[i];
      for (int j = i + 1; j < nums.length; j++) {
        p[j] = p[j] - cur;
        if (p[j] == k) {
          res++;
        }
      }
    }
    return res;
  }
}
