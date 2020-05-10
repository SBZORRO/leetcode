import java.util.Arrays;

public class No189_RotateArray {
//  Given an array, rotate the array to the right by k steps, where k is non-negative.
//
//  Follow up:
//
//      Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
//      Could you do it in-place with O(1) extra space?
//
//   
//
//  Example 1:
//
//  Input: nums = [1,2,3,4,5,6,7], k = 3
//  Output: [5,6,7,1,2,3,4]
//  Explanation:
//  rotate 1 steps to the right: [7,1,2,3,4,5,6]
//  rotate 2 steps to the right: [6,7,1,2,3,4,5]
//  rotate 3 steps to the right: [5,6,7,1,2,3,4]
//
//  Example 2:
//
//  Input: nums = [-1,-100,3,99], k = 2
//  Output: [3,99,-1,-100]
//  Explanation: 
//  rotate 1 steps to the right: [99,-1,-100,3]
//  rotate 2 steps to the right: [3,99,-1,-100]
//
//   
//
//  Constraints:
//
//      1 <= nums.length <= 2 * 10^4
//      It's guaranteed that nums[i] fits in a 32 bit-signed integer.
//      k >= 0
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/rotate-array
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No189_RotateArray test = new No189_RotateArray();
  }

  public void rotate(int[] nums, int k) {
    k = k % nums.length;
    int[] a1 = Arrays.copyOfRange(nums, nums.length - k, nums.length);
    int[] a2 = Arrays.copyOfRange(nums, 0, nums.length - k);
    System.arraycopy(a1, 0, nums, 0, a1.length);
    System.arraycopy(a2, 0, nums, a1.length, a2.length);
  }
}
