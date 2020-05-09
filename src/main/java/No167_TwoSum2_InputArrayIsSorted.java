import java.util.HashMap;

public class No167_TwoSum2_InputArrayIsSorted {
//  Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
//
//  The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
//
//  Note:
//
//      Your returned answers (both index1 and index2) are not zero-based.
//      You may assume that each input would have exactly one solution and you may not use the same element twice.
//
//  Example:
//
//  Input: numbers = [2,7,11,15], target = 9
//  Output: [1,2]
//  Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No167_TwoSum2_InputArrayIsSorted test = new No167_TwoSum2_InputArrayIsSorted();
    test.twoSum(new int[] { 2, 7, 11, 15 }, 9);
  }

  public int[] twoSum(int[] numbers, int target) {
    if (numbers == null || numbers.length == 0) {
      return null;
    }
    for (int i = 0, j = numbers.length - 1; i <= j;) {
      if (numbers[i] + numbers[j] > target) {
        j--;
      } else if (numbers[i] + numbers[j] < target) {
        i++;
      } else {
        return new int[] { i + 1, j + 1 };
      }
    }
    return null;
  }

  public int[] twoSum1(int[] numbers, int target) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < numbers.length; i++) {
      if (!map.containsKey(numbers[i])) {
        map.put(target - numbers[i], i);
      } else {
        int[] pos = new int[2];
        pos[0] = map.get(numbers[i]) + 1;
        pos[1] = i + 1;
        return pos;
      }
    }
    return null;
  }
}
