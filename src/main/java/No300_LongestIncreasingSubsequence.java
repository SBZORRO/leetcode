public class No300_LongestIncreasingSubsequence {
//  Given an unsorted array of integers, find the length of longest increasing subsequence.
//
//  Example:
//
//  Input: [10,9,2,5,3,7,101,18]
//  Output: 4 
//  Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
//
//  Note:
//
//      There may be more than one LIS combination, it is only necessary for you to return the length.
//      Your algorithm should run in O(n2) complexity.
//
//  Follow up: Could you improve it to O(n log n) time complexity?
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No300_LongestIncreasingSubsequence cc = new No300_LongestIncreasingSubsequence();
//    System.out.println(cc.lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
//    System.out.println(cc.lengthOfLIS(new int[] { 0 }));
//    System.out.println(cc.lengthOfLIS(new int[] { -2, -1, 0 }));
    System.out.println(cc.lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 4 }));

  }

  static class TreeNode {
    int      val;
    TreeNode left;
    TreeNode rigth;

    public TreeNode(int i) {
      val = i;
    }
  }

  TreeNode head = null;
  TreeNode cur  = head;

  public void add(TreeNode tree) {
    while (true) {
      if (head == null) {
        head = tree;
        break;
      } else if (tree.val == cur.val) {
        break;
      } else if (tree.val < cur.val) {
        cur.val = tree.val;
        break;
      } else if (tree.val > cur.val) {
        if (cur.rigth == null) {
          cur.rigth = tree;
          break;
        } else {
          cur = cur.rigth;
          continue;
        }
      }
    }
    cur = head;
  }

  public int lengthOfLIS(int[] nums) {
    for (int i : nums) {
      add(new TreeNode(i));
    }

    for (int i = 0;; i++) {
      if (cur == null) {
        return i;
      }
      cur = cur.rigth;
    }
  }

  public int lengthOfLIS1(int[] nums) {
    int[] len = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      int max = 0;
      for (int j = 0; j <= i; j++) {
        if (nums[i] > nums[j]) {
          if (max < len[j]) {
            max = len[j];
          }
        }
      }
      len[i] = max + 1;
    }
    int max = 0;
    for (int i : len) {
      if (i > max) {
        max = i;
      }
    }
    return max;
  }
}