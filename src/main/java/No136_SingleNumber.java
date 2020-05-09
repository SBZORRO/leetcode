public class No136_SingleNumber {
//  Given a non-empty array of integers, every element appears twice except for one. Find that single one.
//
//  Note:
//
//  Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
//
//  Example 1:
//
//  Input: [2,2,1]
//  Output: 1
//
//  Example 2:
//
//  Input: [4,1,2,1,2]
//  Output: 4
//
//
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/single-number
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No136_SingleNumber test = new No136_SingleNumber();
  }

  public int singleNumber(int[] nums) {
    int xor = nums[0];
    for (int i = 1; i < nums.length; i++) {
      xor = xor ^ nums[i];
    }
    if (xor == 0) {
      return 0;
    }
    for (int i = 0; i < nums.length; i++) {
      if ((xor ^ nums[i]) == 0) {
        return nums[i];
      }
    }
    return 0;
  }
}
