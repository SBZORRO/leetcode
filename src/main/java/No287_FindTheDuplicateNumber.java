public class No287_FindTheDuplicateNumber {
//  Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
//
//  Example 1:
//
//  Input: [1,3,4,2,2]
//  Output: 2
//
//  Example 2:
//
//  Input: [3,1,3,4,2]
//  Output: 3
//
//  Note:
//
//      You must not modify the array (assume the array is read only).
//      You must use only constant, O(1) extra space.
//      Your runtime complexity should be less than O(n2).
//      There is only one duplicate number in the array, but it could be repeated more than once.

  public static void main(String[] args) {
    No287_FindTheDuplicateNumber test = new No287_FindTheDuplicateNumber();
    test.findDuplicate(new int[] { 3, 1, 3, 4, 2 });
  }

  public int findDuplicate(int[] nums) {
    int xor = 0;
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        xor = nums[i] ^ nums[j];
        if (xor == 0) {
          res = nums[i];
        }
      }
    }
    return res;
  }
}