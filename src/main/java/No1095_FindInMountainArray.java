public class No1095_FindInMountainArray {
//  (This problem is an interactive problem.)
//
//  You may recall that an array A is a mountain array if and only if:
//
//      A.length >= 3
//      There exists some i with 0 < i < A.length - 1 such that:
//          A[0] < A[1] < ... A[i-1] < A[i]
//          A[i] > A[i+1] > ... > A[A.length - 1]
//
//  Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target.  If such an index doesn't exist, return -1.
//
//  You can't access the mountain array directly.  You may only access the array using a MountainArray interface:
//
//      MountainArray.get(k) returns the element of the array at index k (0-indexed).
//      MountainArray.length() returns the length of the array.
//
//  Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.
//
//   
//
//  Example 1:
//
//  Input: array = [1,2,3,4,5,3,1], target = 3
//  Output: 2
//  Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
//
//  Example 2:
//
//  Input: array = [0,1,2,4,2,1], target = 3
//  Output: -1
//  Explanation: 3 does not exist in the array, so we return -1.
//
//   
//
//  Constraints:
//
//      3 <= mountain_arr.length() <= 10000
//      0 <= target <= 10^9
//      0 <= mountain_arr.get(index) <= 10^9
//
//
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/find-in-mountain-array
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No1095_FindInMountainArray test = new No1095_FindInMountainArray();

//    System.out
//        .println(
//            test.findInMountainArray(2, new MountainArray(new int[] { 1, 5, 2 })));
    System.out
        .println(
            test.findInMountainArray(0, new MountainArray(new int[] { 0, 5, 3, 1 })));
  }

  // This is MountainArray's API interface.
  // You should not implement it, or speculate about its implementation
  static class MountainArray {
    int[] a;

    public MountainArray(int[] a) {
      this.a = a;
    }

    public int get(int index) {
      return a[index];
    }

    public int length() {
      return a.length;
    }
  }

  public int findInMountainArray(int target, MountainArray mountainArr) {
    int len = mountainArr.length();
    int begi = 0;
    int endi = len - 1;
    int midi = len / 2;
    int mid = mountainArr.get(midi);
    while (!(mid > mountainArr.get(midi + 1) && mid > mountainArr.get(midi - 1))) {
      if ((midi - 1 >= 0 && mid >= mountainArr.get(midi - 1))
          || (midi + 1 < len && mid <= mountainArr.get(midi + 1))) {
        begi = midi + 1;
        midi = (begi + endi) / 2;
        mid = mountainArr.get(midi);
      } else if ((midi - 1 >= 0 && mid <= mountainArr.get(midi - 1))
          || (midi + 1 < len && mid >= mountainArr.get(midi + 1))) {
        endi = midi - 1;
        midi = (begi + endi) / 2;
        mid = mountainArr.get(midi);
      }
    }

    int pos = midi;
    begi = 0;
    endi = midi;
    midi = (begi + endi) / 2;
    mid = mountainArr.get(midi);
    while (begi <= endi && mid != target) {
      if (mid > target) {
        endi = midi - 1;
        midi = (begi + endi) / 2;
        mid = mountainArr.get(midi);
      } else if (mid < target) {
        begi = midi + 1;
        midi = (begi + endi) / 2;
        mid = mountainArr.get(midi);
      }
    }
    if (mid == target) {
      return midi;
    }

    midi = pos;
    begi = midi;
    endi = mountainArr.length() - 1;
    midi = (begi + endi) / 2;
    mid = mountainArr.get(midi);
    while (begi <= endi && mid != target) {
      if (mid < target) {
        endi = midi - 1;
        midi = (begi + endi) / 2;
        mid = mountainArr.get(midi);
      } else if (mid > target) {
        begi = midi + 1;
        midi = (begi + endi) / 2;
        mid = mountainArr.get(midi);
      }
    }
    if (mid == target) {
      return midi;
    }
    return -1;
  }

}