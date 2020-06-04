public class No837_New21Game {
//  Alice plays the following game, loosely based on the card game "21".
//
//  Alice starts with 0 points, and draws numbers while she has less than K points.  During each draw, she gains an integer number of points randomly from the range [1, W], where W is an integer.  Each draw is independent and the outcomes have equal probabilities.
//
//  Alice stops drawing numbers when she gets K or more points.  What is the probability that she has N or less points?
//
//  Example 1:
//
//  Input: N = 10, K = 1, W = 10
//  Output: 1.00000
//  Explanation:  Alice gets a single card, then stops.
//
//  Example 2:
//
//  Input: N = 6, K = 1, W = 10
//  Output: 0.60000
//  Explanation:  Alice gets a single card, then stops.
//  In 6 out of W = 10 possibilities, she is at or below N = 6 points.
//
//  Example 3:
//
//  Input: N = 21, K = 17, W = 10
//  Output: 0.73278
//
//  Note:
//
//      0 <= K <= N <= 10000
//      1 <= W <= 10000
//      Answers will be accepted as correct if they are within 10^-5 of the correct answer.
//      The judging time limit has been reduced for this question.
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/new-21-game
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No837_New21Game test = new No837_New21Game();
    System.out.println(test.new21Game(21, 17, 10));

  }

  public double new21Game(int N, int K, int W) {
    if (K == 0) {
      return 1;
    }
    if (K > N) {
      return 0;
    }
    double[] p = new double[K + W];
    double sum = 0;
    for (int i = K; i <= K - 1 + W; i++) {
      if (i > N) {
        p[i] = 0;
      } else {
        p[i] = 1;
        sum = sum + p[i];
      }
    }
    p[K - 1] = sum / W;
    for (int i = K - 2; i >= 0; i--) {
      p[i] = p[i + 1] + p[i + 1] / W - p[i + W + 1] / W;

    }
    return p[0];
  }

  public double new21Game1(int N, int K, int W) {
    if (K == 0) {
      return 1;
    }
    if (K > N) {
      return 0;
    }
    double[] p = new double[K + W];
    for (int i = K; i <= K - 1 + W; i++) {
      if (i > N) {
        p[i] = 0;
      } else {
        p[i] = 1;
      }
    }
    for (int i = K - 1; i >= 0; i--) {
      double sum = 0;
      for (int j = i + 1; j < i + 1 + W; j++) {
        sum = sum + p[j];
      }
      p[i] = sum / W;
    }
    return p[0];
  }
}
