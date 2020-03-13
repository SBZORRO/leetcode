import java.util.Arrays;

public class No4_MedianOfTwoSortedArrays {
//  There are two sorted arrays nums1 and nums2 of size m and n respectively.
//
//  Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
//
//  You may assume nums1 and nums2 cannot be both empty.
//
//  Example 1:
//
//  nums1 = [1, 3]
//  nums2 = [2]
//
//  The median is 2.0
//
//  Example 2:
//
//  nums1 = [1, 2]
//  nums2 = [3, 4]
//
//  The median is (2 + 3)/2 = 2.5
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No4_MedianOfTwoSortedArrays test = new No4_MedianOfTwoSortedArrays();
    System.out.println(1 / 2);
//    System.out.println(test.isValid("()[]{}"));
//    System.out.println(test.isValid("([)]"));
//    System.out.println(test.isValid("{[()]}"));
  }

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int len1 = nums1.length / 2;

    int len2 = nums2.length / 2;

    int[] mid1 = null;
    int[] mid2 = null;
    if (nums1[len1] >= nums2[len2] && nums1[len1] <= nums2[len2 + 1]) {
      mid1 = Arrays.copyOfRange(nums1, 0, len1);
    } else if (nums2[len2] >= nums1[len1] && nums2[len2] <= nums1[len1 + 1]) {
      mid1 = Arrays.copyOfRange(nums2, 0, len2);
    }
    if (nums1[len1 + 1] <= nums2[len2 + 1] && nums1[len1 + 1] >= nums2[len2]) {
      mid2 = Arrays.copyOfRange(nums1, len1 + 1, nums1.length);
    } else if (nums2[len2 + 1] >= nums1[len1] && nums2[len2 + 1] <= nums1[len1 + 1]) {
      mid2 = Arrays.copyOfRange(nums2, len2 + 1, nums2.length);
    }

    return findMedianSortedArrays(mid1, mid2);
  }

}
