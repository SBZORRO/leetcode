import java.util.HashMap;
import java.util.Map;

public class No190_ReverseBits {
//  Reverse bits of a given 32 bits unsigned integer.
//
//  
//
//  Example 1:
//
//  Input: 00000010100101000001111010011100
//  Output: 00111001011110000010100101000000
//  Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
//
//  Example 2:
//
//  Input: 11111111111111111111111111111101
//  Output: 10111111111111111111111111111111
//  Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10111111111111111111111111111111.
//
//   
//
//  Note:
//
//      Note that in some languages such as Java, there is no unsigned integer type. In this case, both input and output will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
//      In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above the input represents the signed integer -3 and the output represents the signed integer -1073741825.
//
//   
//
//  Follow up:
//
//  If this function is called many times, how would you optimize it?
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/reverse-bits
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No190_ReverseBits test = new No190_ReverseBits();
    System.out.println(test.reverseBits(10));
  }

  Map<Integer, Integer> map = new HashMap<Integer, Integer>() {
    private static final long serialVersionUID = 1L;
    {
      put(1, 1 << 31);
      put(1 << 1, 1 << 30);
      put(1 << 2, 1 << 29);
      put(1 << 3, 1 << 28);
      put(1 << 4, 1 << 27);
      put(1 << 5, 1 << 26);
      put(1 << 6, 1 << 25);
      put(1 << 7, 1 << 24);
      put(1 << 8, 1 << 23);
      put(1 << 9, 1 << 22);
      put(1 << 10, 1 << 21);
      put(1 << 11, 1 << 20);
      put(1 << 12, 1 << 19);
      put(1 << 13, 1 << 18);
      put(1 << 14, 1 << 17);
      put(1 << 15, 1 << 16);
      put(1 << 16, 1 << 15);
      put(1 << 17, 1 << 14);
      put(1 << 18, 1 << 13);
      put(1 << 19, 1 << 12);
      put(1 << 20, 1 << 11);
      put(1 << 21, 1 << 10);
      put(1 << 22, 1 << 9);
      put(1 << 23, 1 << 8);
      put(1 << 24, 1 << 7);
      put(1 << 25, 1 << 6);
      put(1 << 26, 1 << 5);
      put(1 << 27, 1 << 4);
      put(1 << 28, 1 << 3);
      put(1 << 29, 1 << 2);
      put(1 << 30, 1 << 1);
      put(1 << 31, 1);
    }
  };

  // you need treat n as an unsigned value
  public int reverseBits(int n) {
    int res = 0;
    for (Map.Entry<Integer, Integer> e : map.entrySet()) {
      if ((n & e.getKey()) == e.getKey()) {
        res += e.getValue();
      }
    }
    return res;
  }
}
