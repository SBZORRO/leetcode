class No152_MaximumProductSubarray {
//  Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
//
//  Example 1:
//
//  Input: [2,3,-2,4]
//  Output: 6
//  Explanation: [2,3] has the largest product 6.
//
//  Example 2:
//
//  Input: [-2,0,-1]
//  Output: 0
//  Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/maximum-product-subarray
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
  public static void main(String[] args) {
    No152_MaximumProductSubarray test = new No152_MaximumProductSubarray();
    System.out.println(test.maxProduct(new int[] { -2, 0, -1 }));
    System.out.println(test.maxProduct(new int[] { -4, -3 }));
    System.out.println(test.maxProduct(new int[] { -1, -2, -3, 0 }));
    System.out.println(test.maxProduct(new int[] { 2, 0, 3, -2 }));
    System.out.println(test.maxProduct(new int[] { 6, 3, -10, 0, 2 }));
    System.out.println(test.maxProduct(new int[] { -2, 0, -3, -3 }));
  }

  public int maxProduct(int[] nums) {
    int pro = 1;
    int m1 = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      if (pro == 0) {
        pro = 1;
      }
      pro = pro * nums[i];
      m1 = Math.max(m1, pro);
    }
    int m2 = Integer.MIN_VALUE;
    pro = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      if (pro == 0) {
        pro = 1;
      }
      pro = pro * nums[i];
      m2 = Math.max(m2, pro);
    }
    return Math.max(m1, m2);
  }

  public int maxProduct2(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    int anchor = 0;
    int zero = 1;
    int[] p = new int[nums.length + 1];
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        zero = 0;
        while (i < nums.length && nums[i] == 0) {
          i++;
        }
        if (i >= nums.length) {
          break;
        }

        anchor = i;
        p[anchor] = nums[i];
      } else {
        if (p[anchor] == 0) {
          p[anchor] = nums[i];
        } else {
          p[anchor] *= nums[i];
        }
      }
    }

    int max = Integer.MIN_VALUE;
    int tmp = 0;
    int product = 0;
    for (int i = 0; i < nums.length; i++) {
      while (i < nums.length && nums[i] == 0) {
        i++;
        product = 0;
      }
      if (i >= nums.length) {
        break;
      }
      if (product == 0) {
        product = p[i];
        max = Math.max(max, product);
      }
      p[i + 1] = p[i] / nums[i];
      tmp = p[i + 1] == 1 ? p[i] : product / p[i + 1];
      p[i + 1] = p[i + 1] == 1 ? p[i] : p[i + 1];

      max = Math.max(max, Math.max(tmp, p[i + 1]));
    }

    return max <= 0 && zero == 0 ? zero : max;
  }

  public int maxProduct1(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

//    int[][] p = new int[nums.length][nums.length];
    int pre = 0;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i; j < nums.length; j++) {
        if (i == j) {
          pre = nums[i];
        } else {
          pre = pre * nums[j];
        }
        max = Math.max(max, pre);
      }
    }
    return max;
  }
}
