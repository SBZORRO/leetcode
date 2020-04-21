import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class No1248_CountNumberOfNiceSubarrays {
//  Given an array of integers nums and an integer k. A subarray is called nice if there are k odd numbers on it.
//
//  Return the number of nice sub-arrays.
//
//   
//
//  Example 1:
//
//  Input: nums = [1,1,2,1,1], k = 3
//  Output: 2
//  Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
//
//  Example 2:
//
//  Input: nums = [2,4,6], k = 1
//  Output: 0
//  Explanation: There is no odd numbers in the array.
//
//  Example 3:
//
//  Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
//  Output: 16
//
//   
//
//  Constraints:
//
//      1 <= nums.length <= 50000
//      1 <= nums[i] <= 10^5
//      1 <= k <= nums.length
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/count-number-of-nice-subarrays
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No1248_CountNumberOfNiceSubarrays test = new No1248_CountNumberOfNiceSubarrays();

//    System.out.print(test.numberOfSubarrays(new int[] { 1, 1, 2, 1, 1 }, 3));
    System.out.print(test.numberOfSubarrays(new int[] { 2, 2, 2, 1, 2, 1, 1, 2, 2, 2 }, 2));
  }

  public int numberOfSubarrays(int[] nums, int k) {
    List<Integer> list = new LinkedList<>();
    int ans = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] % 2 != 0) {
        list.add(i);
      }
    }
    int beg = -1;
    int end = -1;
    int prev = 0;
    int next = 0;
    while (list.size() >= k) {
      beg = list.get(0);
      end = list.get(k - 1);

      if (list.size() == k) {
        next = nums.length;
      } else {
        next = list.get(k);
      }
      list.remove(0);
      ans = ans + (beg - prev + 1) * (next - end);
      prev = beg + 1;
    }
    return ans;
  }

  public int numberOfSubarrays1(int[] nums, int k) {
    int beg = -1;
    int end = -1;
    int next = -1;
    int count = 0;
    int ans = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] % 2 != 0) {
        if (count == k) {
          next = i;
          break;
        }
        if (beg == -1) {
          beg = i;
        }
        end = i;
        count++;
      }

    }
    if (count < k) {
      return 0;
    }
    if (next == -1) {
      next = nums.length;
      return (beg + 1) * (next - end);
    }
    ans = (beg + 1) * (next - end);

    ans = ans + numberOfSubarrays(Arrays.copyOfRange(nums, beg + 1, nums.length), k);

    return ans;
  }
}
