public class No238_ProductOfArrayExceptSelf {
//  Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
//
//      Example:
//
//      Input:  [1,2,3,4]
//      Output: [24,12,8,6]
//
//      Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.
//
//      Note: Please solve it without division and in O(n).
//
//      Follow up:
//      Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
//
//      来源：力扣（LeetCode）
//      链接：https://leetcode-cn.com/problems/product-of-array-except-self
//      著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No238_ProductOfArrayExceptSelf test = new No238_ProductOfArrayExceptSelf();
    test.productExceptSelf(new int[] { 1, 2, 3, 4 });

  }

  public int[] productExceptSelf(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new int[0];
    }
    if (nums.length == 1) {
      return nums;
    }
    int sum = 1;
    int[] p = new int[nums.length];
    p[0] = 1;
    for (int i = 1; i < nums.length; i++) {
      sum = nums[i - 1] * sum;
      p[i] = sum;
    }
    sum = 1;
    for (int i = nums.length - 2; i >= 0; i--) {
      sum = nums[i + 1] * sum;
      p[i] = sum * p[i];
    }
    return p;
  }
}