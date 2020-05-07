class No88_MergeSortedArray {
//  Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
//
//  Note:
//
//      The number of elements initialized in nums1 and nums2 are m and n respectively.
//      You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
//
//  Example:
//
//  Input:
//  nums1 = [1,2,3,0,0,0], m = 3
//  nums2 = [2,5,6],       n = 3
//
//  Output: [1,2,2,3,5,6]
//
//
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/merge-sorted-array
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No88_MergeSortedArray test = new No88_MergeSortedArray();

//    test.merge(new int[] { 1, 2, 3, 0, 0, 0 }, 3, new int[] { 2, 5, 6 }, 3);
    test.merge(new int[] { 2, 0 }, 1, new int[] { 1 }, 1);
    test.merge(new int[] { 0, 0, 3, 0, 0, 0, 0, 0, 0 }, 3, new int[] { -1, 1, 1, 1, 2, 3 }, 6);
  }

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    if (n == 0) {
      return;
    }
//    if (m == 0) {
//      for (int i = 0; i < nums1.length; i++) {
//        nums1[i] = nums2[i];
//      }
//      return;
//    }
    int i = 0;
    int j = 0;
    int k = 0;
    for (i = m - 1, j = n - 1, k = m + n - 1; i >= 0 && j >= 0 && k >= 0; k--) {
      if (nums1[i] > nums2[j]) {
        nums1[k] = nums1[i];
        i--;
      } else if (nums1[i] < nums2[j]) {
        nums1[k] = nums2[j];
        j--;
      } else if (nums1[i] == nums2[j]) {
        nums1[k] = nums1[i];
        nums1[k - 1] = nums2[j];
        i--;
        j--;
        k--;
      }
    }

    for (; k >= 0 && j >= 0; k--, j--) {
      nums1[k] = nums2[j];

    }
  }
}
