public class No27_RemoveElement {
//  Given an array nums and a value val, remove all instances of that value in-place and return the new length.
//
//      Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
//
//      The order of elements can be changed. It doesn't matter what you leave beyond the new length.
//
//      Example 1:
//
//      Given nums = [3,2,2,3], val = 3,
//
//      Your function should return length = 2, with the first two elements of nums being 2.
//
//      It doesn't matter what you leave beyond the returned length.
//
//      Example 2:
//
//      Given nums = [0,1,2,2,3,0,4,2], val = 2,
//
//      Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
//
//      Note that the order of those five elements can be arbitrary.
//
//      It doesn't matter what values are set beyond the returned length.

  public static void main(String[] args) {
    No27_RemoveElement test = new No27_RemoveElement();
    System.out.println(test.removeElement(new int[] { 3, 2, 2, 3 }, 3));
    System.out.println(test.removeElement(new int[] { 1, 1, 1, 1, 1, 2, 2 }, 2));
    System.out.println(test.removeElement(new int[] { 1, 2, 2 }, 2));

  }

  public int removeElement(int[] nums, int val) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    if (nums.length == 1 && nums[0] == val) {
      return 0;
    }
    int ans = 0;
    for (int i = 0; i < nums.length; i++) {
      while (nums[ans] != val) {
        ans++;
        if (ans == nums.length) {
          return ans;
        }
      }
      i = ans;
      while (nums[i] == val) {
        i++;
        if (i == nums.length) {
          return ans;
        }
      }
      while (nums[ans] == val && nums[i] != val) {
        nums[ans] = nums[i];
        nums[i] = val;
        ans++;
        i++;
        if (ans == nums.length || i == nums.length) {
          return ans;
        }
      }
    }
    return ans;
  }
}
