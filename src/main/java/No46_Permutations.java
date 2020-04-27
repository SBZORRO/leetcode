import java.util.LinkedList;
import java.util.List;

public class No46_Permutations {
//  Given a collection of distinct integers, return all possible permutations.
//
//      Example:
//
//      Input: [1,2,3]
//      Output:
//      [
//        [1,2,3],
//        [1,3,2],
//        [2,1,3],
//        [2,3,1],
//        [3,1,2],
//        [3,2,1]
//      ]
//
//      来源：力扣（LeetCode）
//      链接：https://leetcode-cn.com/problems/permutations
//      著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No46_Permutations test = new No46_Permutations();
    System.out.println(test.permute(new int[] { 1, 2, 3, 4 }));
  }

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> list = new LinkedList<>();
    int len = nums.length;
    int total = exclamation(nums.length);
    for (int i = 0; i < total; i++) {
      List<Integer> li = new LinkedList<>();
      list.add(li);
    }
    int loop = len;
    int tier = 0;
    int repeat = total;
    List<Integer> li = null;
    for (int j = 0; j < len; j++) {
      repeat = repeat / loop;
      while (tier < list.size()) {
        for (int i = 0; i < len && tier < list.size(); i++) {
          for (int k = repeat; k >= 1 && tier < list.size(); k--) {
            li = list.get(tier);
            if (!li.contains(nums[i])) {
              li.add(nums[i]);
            } else {
              break;
            }
            tier++;
          }
        }
      }
      tier = 0;
      loop--;
    }
    return list;
  }

  public int exclamation(int n) {
    int ans = 1;
    for (; n >= 1; n--) {
      ans = ans * n;
    }
    return ans;
  }
}
