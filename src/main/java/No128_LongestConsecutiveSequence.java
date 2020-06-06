import java.util.HashMap;
import java.util.Map;

public class No128_LongestConsecutiveSequence {
//  Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//
//  Your algorithm should run in O(n) complexity.
//
//  Example:
//
//  Input: [100, 4, 200, 1, 3, 2]
//  Output: 4
//  Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
//
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  public static void main(String[] args) {
    longestConsecutive(new int[] { 9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6 });
  }

  public static int longestConsecutive(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], 1);
    }
    int max = 1;
    for (int i = 0; i < nums.length; i++) {
      int t = nums[i];
      if (map.containsKey(t)) {
        int num = 1;
        int j = t - 1;
        int k = t + 1;
        boolean con = true;
        while (con) {
          con = false;
          if (map.containsKey(j)) {
            map.remove(j);
            num++;
            con = true;
            j--;

          }
          if (map.containsKey(k)) {
            map.remove(k);
            num++;
            con = true;
            k++;
          }
        }
        if (num > 1) {
          map.put(t, num);
          max = Math.max(max, num);
        }
      }
    }
    return max;
  }
}