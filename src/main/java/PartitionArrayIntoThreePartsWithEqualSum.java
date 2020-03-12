public class PartitionArrayIntoThreePartsWithEqualSum {
//  Given an array A of integers, return true if and only if we can partition the array into three non-empty parts with equal sums.
//
//      Formally, we can partition the array if we can find indexes i+1 < j with (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])
//
//       
//
//      Example 1:
//
//      Input: A = [0,2,1,-6,6,-7,9,1,2,0,1]
//      Output: true
//      Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
//
//      Example 2:
//
//      Input: A = [0,2,1,-6,6,7,9,-1,2,0,1]
//      Output: false
//
//      Example 3:
//
//      Input: A = [3,3,6,5,-2,2,5,1,-9,4]
//      Output: true
//      Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
//
//       
//
//      Constraints:
//
//          3 <= A.length <= 50000
//          -10^4 <= A[i] <= 10^4
//
//      来源：力扣（LeetCode）
//      链接：https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum
//      著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    PartitionArrayIntoThreePartsWithEqualSum test = new PartitionArrayIntoThreePartsWithEqualSum();
    System.out.println(test.canThreePartsEqualSum(new int[] { 1, -1, 1, -1 }));
//    System.out.println(test.isValid("()[]{}"));
//    System.out.println(test.isValid("([)]"));
//    System.out.println(test.isValid("{[()]}"));
  }

  public boolean canThreePartsEqualSum(int[] A) {
    if (A == null || A.length < 3) {
      return false;
    }
    int sum = 0;
    int partition = 0;
    for (int i : A) {
      sum = sum + i;
    }
    
    if (sum % 3 != 0) {
      return false;
    }
    
    partition = sum / 3;
    
    int first = 0;
    int idx = 0;
    do {

      first = first + A[idx];
      idx++;
    } while (first != partition && idx <= A.length - 3);

    if (first != partition) {
      return false;
    }

    int last = 0;
    int j = A.length - 1;
    do {
      last = last + A[j];
      j--;
    } while (last != partition && j > idx);

    if (last != partition) {
      return false;
    }

    return true;
    
  }
}
