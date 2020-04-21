class No11_ContainerWithMostWater {
//  Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
//
//  Note: You may not slant the container and n is at least 2.
//
//   
//
//  The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
//
//   
//
//  Example:
//
//  Input: [1,8,6,2,5,4,8,3,7]
//  Output: 49
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/container-with-most-water
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No11_ContainerWithMostWater test = new No11_ContainerWithMostWater();
    System.out.println(test.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
    System.out.println(test.maxArea(new int[] { 2, 3, 4, 5, 18, 17, 6 }));
  }

  public int maxArea(int[] height) {
    int max = 0;
    for (int i = 0, j = height.length - 1; i < j;) {
      int bot = j - i;
      int hit = Math.min(height[i], height[j]);
      max = Math.max(max, bot * hit);

      if (height[i] < height[j]) {
        i++;
      } else if (height[j] < height[i]) {
        j--;
      } else if (height[i] == height[j]) {
        i++;
        j--;
      }
    }
    return max;
  }

  public int maxArea1(int[] height) {
    int max = 0;
    for (int i = 0; i < height.length; i++) {
      if (height[i] == 0) {
        continue;
      }
      for (int j = height.length - 1; j > i; j--) {
        int bot = j - i;

        if (max / height[i] >= bot) {
          break;
        }
        int hit = Math.min(height[i], height[j]);
        max = Math.max(max, bot * hit);
        if (hit == height[i]) {
          break;
        }
      }
    }
    return max;
  }
}
