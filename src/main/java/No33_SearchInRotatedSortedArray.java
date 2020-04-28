public class No33_SearchInRotatedSortedArray {
//  Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
//  (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
//
//  You are given a target value to search. If found in the array return its index, otherwise return -1.
//
//  You may assume no duplicate exists in the array.
//
//  Your algorithm's runtime complexity must be in the order of O(log n).
//
//  Example 1:
//
//  Input: nums = [4,5,6,7,0,1,2], target = 0
//  Output: 4
//
//  Example 2:
//
//  Input: nums = [4,5,6,7,0,1,2], target = 3
//  Output: -1

  public static void main(String[] args) {
    No33_SearchInRotatedSortedArray test = new No33_SearchInRotatedSortedArray();
    System.out.println(test.search(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 0 }, 0));
    System.out.println(test.search(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13 }, 0));
    System.out.println(test.search(new int[] { 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 0, 1, 2 }, 0));
    System.out.println(test.search(new int[] { 14, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13 }, 0));
    System.out.println(test.search(new int[] { 12, 13, 14, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11 }, 0));
    System.out.println(test.search(new int[] { 3 }, 3));
    System.out.println(test.search(new int[] { 4, 3 }, 3));
    System.out.println(test.search(new int[] { 1, 3, 5 }, 2));

  }

  public int search(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return -1;
    } else if (nums.length == 1) {
      if (nums[0] == target) {
        return 0;
      } else {
        return -1;
      }
    } else if (nums.length == 2) {
      if (nums[0] == target) {
        return 0;
      } else if (nums[1] == target) {
        return 1;
      } else {
        return -1;
      }
    }

    int begi = 0;
    int endi = nums.length - 1;
    int midi = nums.length / 2;
    int beg = nums[0];
    int end = nums[nums.length - 1];
    int mid = nums[nums.length / 2];
    if (nums[0] > nums[nums.length - 1]) {
      while (!((nums[midi - 1] < nums[midi] && nums[midi + 1] < nums[midi])
          || (nums[midi - 1] > nums[midi] && nums[midi + 1] > nums[midi]))) {
        if (mid > beg && mid > end) {
          beg = mid;
          begi = midi;
          midi = (begi + endi) / 2;
          mid = nums[midi];
        } else if (mid < beg && mid < end) {
          end = mid;
          endi = midi;
          midi = (begi + endi) / 2;
          mid = nums[midi];
        }
      }

      int max = 0;
      int min = 0;
      int maxi = 0;
      int mini = 0;
      if (nums[midi - 1] < nums[midi] && nums[midi + 1] < nums[midi]) {
        max = mid;
        maxi = midi;
        mini = midi + 1;
        min = nums[mini];
      }
      if (nums[midi - 1] > nums[midi] && nums[midi + 1] > nums[midi]) {
        min = mid;
        mini = midi;
        maxi = midi - 1;
        max = nums[maxi];
      }
      if (target >= nums[0]) {
        begi = 0;
        beg = nums[begi];
        endi = maxi;
        midi = (begi + endi) / 2;
        mid = nums[midi];
      }
      if (target <= nums[nums.length - 1]) {
        begi = mini;
        beg = nums[begi];
        endi = nums.length - 1;
        end = nums[endi];
        midi = (begi + endi) / 2;
        mid = nums[midi];
      }
    }
    while (target != mid && (begi < endi)) {
      if (target > mid) {
        midi = midi + 1;
        beg = nums[midi];
        begi = midi;
        midi = (begi + endi) / 2;
        mid = nums[midi];
      } else if (target < mid) {
        midi = midi - 1;
        endi = midi;
        end = nums[endi];
        midi = (begi + endi) / 2;
        mid = nums[midi];
      }
    }
    if (target == mid) {
      return midi;
    } else {
      return -1;
    }
  }

}
