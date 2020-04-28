public class Inteerview561_SingleNumbers {
//  一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
//
//  
//
//  示例 1：
//
//  输入：nums = [4,1,4,6]
//  输出：[1,6] 或 [6,1]
//
//  示例 2：
//
//  输入：nums = [1,2,10,4,1,4,3,3]
//  输出：[2,10] 或 [10,2]
//
//   
//
//  限制：
//
//      2 <= nums <= 10000
//
//   
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    Inteerview561_SingleNumbers test = new Inteerview561_SingleNumbers();

  }

  public int[] singleNumbers(int[] nums) {
    if (nums == null || nums.length == 0) {
      return null;
    }
    int res = nums[0];
    for (int i = 1; i < nums.length; i++) {
      res = res ^ nums[i];
    }
    int op = 1;
    while ((res & op) != op) {
      op = op << 1;
    }
    int a = 0;
    int b = 0;
    for (int i : nums) {
      if ((i & op) == op) {
        a = a ^ i;
      } else if ((i & op) == 0) {
        b = b ^ i;
      }
    }
    return new int[] { a, b };
  }
}
