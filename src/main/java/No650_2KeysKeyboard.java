class No650_2KeysKeyboard {
//  Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:
//
//    Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
//    Paste: You can paste the characters which are copied last time.
//
// 
//
//Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. Output the minimum number of steps to get n 'A'.
//
//Example 1:
//
//Input: 3
//Output: 3
//Explanation:
//Intitally, we have one character 'A'.
//In step 1, we use Copy All operation.
//In step 2, we use Paste operation to get 'AA'.
//In step 3, we use Paste operation to get 'AAA'.
//
// 
//
//Note:
//
//    The n will be in the range [1, 1000].
//
// 
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/2-keys-keyboard
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No650_2KeysKeyboard test = new No650_2KeysKeyboard();
    test.minSteps(9);
  }

  public int minSteps(int n) {

    if (n == 0 || n == 1) {
      return 0;
    }
    int l = (int) Math.sqrt(n);
    int[] p = new int[n / 2 + 1];
    p[0] = 0;
    p[1] = 0;
    int div = 1;
    int min = n;
    for (int i = l; i >= 2; i--) {
      if (n % i == 0) {
        div = n / i;
        int left = 0;
        int right = 0;
        left = p[div] == 0 ? minSteps(div) : p[div];
        right = p[i] == 0 ? minSteps(i) : p[i];
        min = Math.min(min, left + right);

        // 无论是哪一组分解因子，最终都能够分解成一样数量的质数
        // <<数学与泛型编程>>
        break;
      }
    }
    return min;
  }
}
