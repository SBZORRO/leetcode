import java.util.HashMap;

public class No169_MajorityElement {
//  Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
//
//  You may assume that the array is non-empty and the majority element always exist in the array.
//
//  Example 1:
//
//  Input: [3,2,3]
//  Output: 3
//
//  Example 2:
//
//  Input: [2,2,1,1,1,2,2]
//  Output: 2

  public static void main(String[] args) {
    No169_MajorityElement test = new No169_MajorityElement();
    System.out.println(test.majorityElement(new int[] { 3, 2, 3 }));
    System.out.println(test.majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 }));
    System.out.println(test.majorityElement(new int[] { 1 }));

  }

//  思路
//
//  如果我们把众数记为 +1+1+1，把其他数记为 −1-1−1，将它们全部加起来，显然和大于 0，从结果本身我们可以看出众数比其他数多。
//
//  算法
//
//  Boyer-Moore 算法的本质和方法四中的分治十分类似。我们首先给出 Boyer-Moore 算法的详细步骤：
//
//      我们维护一个候选众数 candidate 和它出现的次数 count。初始时 candidate 可以为任意值，count 为 0；
//
//      我们遍历数组 nums 中的所有元素，对于每个元素 x，在判断 x 之前，如果 count 的值为 0，我们先将 x 的值赋予 candidate，随后我们判断 x：
//
//          如果 x 与 candidate 相等，那么计数器 count 的值增加 1；
//
//          如果 x 与 candidate 不等，那么计数器 count 的值减少 1。
//
//      在遍历完成后，candidate 即为整个数组的众数。

//  如果候选人不是maj 则 maj,会和其他非候选人一起反对 会反对候选人,所以候选人一定会下台(maj==0时发生换届选举)
//  如果候选人是maj , 则maj 会支持自己，其他候选人会反对，同样因为maj 票数超过一半，所以maj 一定会成功当选

  public int majorityElement(int[] nums) {
    int cand = 0;
    int count = 0;
    for (int i : nums) {
      if (count == 0) {
        cand = i;
      }
      if (i == cand) {
        count++;
      } else {
        count--;
      }
    }
    return cand;
  }

  public int majorityElement1(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i : nums) {
      int j = 0;
      if (map.containsKey(i)) {
        j = map.get(i) + 1;
      } else {
        j = 1;
      }
      if (j > nums.length / 2) {
        return i;
      }
      map.put(i, j);
    }
    return 0;
  }
}
