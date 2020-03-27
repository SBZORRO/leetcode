public class Interview1716_TheMasseuseLCCI {
//  A popular masseuse receives a sequence of back-to-back appointment requests and is debating which ones to accept. She needs a break between appointments and therefore she cannot accept any adjacent requests. Given a sequence of back-to-back appoint­ ment requests, find the optimal (highest total booked minutes) set the masseuse can honor. Return the number of minutes.
//
//  Note: This problem is slightly different from the original one in the book.
//
//   
//
//  Example 1:
//
//  Input:  [1,2,3,1]
//  Output:  4
//  Explanation:  Accept request 1 and 3, total minutes = 1 + 3 = 4
//
//  Example 2:
//
//  Input:  [2,7,9,3,1]
//  Output:  12
//  Explanation:  Accept request 1, 3 and 5, total minutes = 2 + 9 + 1 = 12
//
//  Example 3:
//
//  Input:  [2,1,4,5,3,1,1,3]
//  Output:  12
//  Explanation:  Accept request 1, 3, 5 and 8, total minutes = 2 + 4 + 3 + 3 = 12

  public static void main(String[] args) {
    Interview1716_TheMasseuseLCCI test = new Interview1716_TheMasseuseLCCI();
    System.out.println(test.massage(new int[] { 2, 1, 4, 5, 3, 1, 1, 3 }));
    System.out.println(test.massage(new int[] { 1, 2, 3, 1 }));
    System.out.println(test.massage(new int[] { 2, 7, 9, 3, 1 }));
  }

  public int massage(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int biggest = nums[0];
    int bigExpPrev = 0;
    int cur = 0;
    for (int i = 1; i < nums.length; i++) {

      cur = nums[i] + bigExpPrev;
      bigExpPrev = biggest;
      if (cur > biggest) {
        biggest = cur;
      }

    }
    return biggest;
  }
}