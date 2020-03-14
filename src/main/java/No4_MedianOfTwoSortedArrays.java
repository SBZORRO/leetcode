import java.util.ArrayList;
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
    System.out.println(test.findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 }));
//    System.out.println(test.findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 }));
//    System.out.println(
//        test.findMedianSortedArrays(new int[] { 6, 8, 9, 11, 23 }, new int[] { 4, 5, 10, 15 }));

  }

  static class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int i) {
      val = i;
    }
  }

  TreeNode           head   = null;
  TreeNode           cur    = head;
  int                l      = 0;
  int                r      = 0;
  ArrayList<Integer> list   = new ArrayList<>();
  int                len    = 0;
  TreeNode           target = null;
  TreeNode           next   = null;

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    for (int i : nums1) {
      add(new TreeNode(i));
    }
    for (int i : nums2) {
      add(new TreeNode(i));
    }
    len = Math.abs(l - r);
    if (len == 0) {
      return head.val;
    }

    len = len - 1;
    if (l > r) {
      findLeft(cur.left);
    } else if (r > l) {
      findRight(cur.right);
    }

    if ((nums1.length + nums2.length) % 2 == 0) {

      return (double) (next.val + target.val) / 2;
    } else {
      return target.val;
    }

  }

  public TreeNode findRight(TreeNode tree) {

    if (tree == null) {
      return null;
    }

    findRight(tree.left);
    len = len - 1;
    if (len == 1) {
      target = tree;
    }
    if (len == 0) {
      next = tree;
    }
    findRight(tree.right);

    return null;

  }

  public TreeNode findLeft(TreeNode tree) {

    if (tree == null) {
      return null;
    }

    findLeft(tree.right);
    len = len - 1;
    if (len == 1) {
      target = tree;
    }
    if (len == 0) {
      next = tree;
    }
    findLeft(tree.left);

    return null;
  }

  public void add(TreeNode tree) {
    if (head == null) {
      head = tree;
      cur = head;
      return;
    } else if (head != null && head.val <= tree.val) {
      r++;
    } else if (head != null && head.val > tree.val) {
      l++;
    }
    while (true) {
      if (tree.val <= cur.val) {
        if (cur.left == null) {
          cur.left = tree;
          break;
        } else {
          cur = cur.left;
          continue;
        }
      } else if (tree.val > cur.val) {
        if (cur.right == null) {
          cur.right = tree;
          break;
        } else {
          cur = cur.right;
          continue;
        }
      }
    }
    cur = head;
  }

  public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
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

    return findMedianSortedArrays1(mid1, mid2);
  }

}
