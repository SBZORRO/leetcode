public class No53_MaximumSubarray {
//  Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
//
//      Example:
//
//      Input: [-2,1,-3,4,-1,2,1,-5,4],
//      Output: 6
//      Explanation: [4,-1,2,1] has the largest sum = 6.
//
//      Follow up:
//
//      If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
//      通过次数212,805
//
//      来源：力扣（LeetCode）
//      链接：https://leetcode-cn.com/problems/maximum-subarray
//      著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  public static void main(String[] args) {
    No53_MaximumSubarray test = new No53_MaximumSubarray();
    System.out.print(test.maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
  }

  public int maxSubArray(int[] nums) {
    int prev = nums[0];
    int max = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int temp = prev + nums[i];
      if (temp >= prev && temp >= nums[i]) {
        prev = temp;
        max = Math.max(max, prev);
      } else if (nums[i] >= temp && nums[i] >= prev) {
        prev = nums[i];
        max = Math.max(max, prev);
      } else if (prev >= temp && prev >= nums[i]) {
        max = Math.max(max, prev);
        prev = Math.max(temp, nums[i]);
      }

      max = Math.max(prev, max);
    }
    return max;
  }
}
