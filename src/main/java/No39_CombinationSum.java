import java.util.Arrays;

public class No39_CombinationSum {
//  Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
//
//  The same repeated number may be chosen from candidates unlimited number of times.
//
//  Note:
//
//      All numbers (including target) will be positive integers.
//      The solution set must not contain duplicate combinations.
//
//  Example 1:
//
//  Input: candidates = [2,3,6,7], target = 7,
//  A solution set is:
//  [
//    [7],
//    [2,2,3]
//  ]
//
//  Example 2:
//
//  Input: candidates = [2,3,5], target = 8,
//  A solution set is:
//  [
//    [2,2,2,2],
//    [2,3,3],
//    [3,5]
//  ]
//
//
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/combination-sum
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No39_CombinationSum test = new No39_CombinationSum();
    System.out.println(test.combinationSum("aabcccccaaa"));
    System.out.println(test.combinationSum("abbccd"));
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);

    for (int i = 0; i < candidates.length; i++) {
      if (candidates[i] > target) {
        candidates = Arrays.copyOfRange(candidates, 0, i);
        break;
      }
    }
    int[][] res = new int[candidates.length][target - candidates[0] + 1];

  }
}
