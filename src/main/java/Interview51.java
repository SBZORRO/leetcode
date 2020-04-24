import java.util.Arrays;

public class Interview51 {
//  在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
//
//  
//
//  示例 1:
//
//  输入: [7,5,6,4]
//  输出: 5
//
//   
//
//  限制：
//
//  0 <= 数组长度 <= 50000
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    Interview51 test = new Interview51();
//    System.out.println(test.reversePairs(new int[] { 7, 5, 6, 4 }));
//    System.out.println(test.reversePairs(new int[] { 1, 3, 2, 3, 1 }));
//    System.out.println(
//        test.reversePairs(
//            new int[] { 233, 233, 233, 233, 2000000004 }));
    System.out.println(
        test.reversePairs(
            new int[] { 233, 2000000001, 234, 2000000006, 235, 2000000003, 236, 2000000007, 237,
                2000000002, 2000000005, 233, 233, 233, 233, 233, 2000000004 }));
  }

  int ans = 0;;

  public int reversePairs(int[] nums) {
    return div(nums);
  }

  public int div(int[] nums) {
    return merge(
        nums,
        Arrays.copyOfRange(nums, 0, nums.length / 2),
        Arrays.copyOfRange(nums, nums.length / 2, nums.length));
  }

  public int merge(int[] nums, int[] a, int[] b) {
    if (a.length > 1) {
      div(a);
    }
    if (b.length > 1) {
      div(b);
    }
    int indi = 0;
    for (int i = 0, j = 0; i < a.length || j < b.length; indi++) {
      if (i == a.length) {
        while (j < b.length) {
          nums[indi] = b[j];
          j++;
          indi++;
        }
      }
      if (j == b.length) {
        while (i < a.length) {
          nums[indi] = a[i];
          i++;
          indi++;
        }
      }
      if (i < a.length && a[i] > b[j]) {
        ans = ans + b.length - j;
        nums[indi] = a[i];
        i++;
      } else if (j < b.length && a[i] <= b[j]) {
        nums[indi] = b[j];
        j++;
      }
    }
    return ans;
  }

  public int reversePairs1(int[] nums) {
    int ans = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] > nums[j]) {
          ans++;
        }
      }
    }
    return ans;
  }
}
