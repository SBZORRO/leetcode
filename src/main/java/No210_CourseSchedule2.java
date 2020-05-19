import java.util.LinkedList;

public class No210_CourseSchedule2 {
//  There are a total of n courses you have to take, labeled from 0 to n-1.
//
//  Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
//
//  Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
//
//  There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
//
//  Example 1:
//
//  Input: 2, [[1,0]] 
//  Output: [0,1]
//  Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
//               course 0. So the correct course order is [0,1] .
//
//  Example 2:
//
//  Input: 4, [[1,0],[2,0],[3,1],[3,2]]
//  Output: [0,1,2,3] or [0,2,1,3]
//  Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
//               courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
//               So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
//
//  Note:
//
//      The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
//      You may assume that there are no duplicate edges in the input prerequisites.
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/course-schedule-ii
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No210_CourseSchedule2 test = new No210_CourseSchedule2();
//    test.findOrder(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 } });
//    test.findOrder(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } });
//    test.findOrder(2, new int[][] { { 1, 0 } });
    test.findOrder(2, new int[][] { { 1, 0 }, { 0, 1 } });
  }

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    if (prerequisites == null) {
      return null;
    }
    int[] res = new int[numCourses];
    if (prerequisites.length == 0) {
      for (int i = 0; i < numCourses; i++) {
        res[i] = i;
      }
      return res;
    }
    LinkedList<LinkedList<Integer>> lis = new LinkedList<LinkedList<Integer>>();
    for (int i = 0; i < numCourses; i++) {
      lis.add(i, null);
    }
    LinkedList<Integer> li = null;
    int course = -1;
    int pre = -1;
    for (int i = 0; i < prerequisites.length; i++) {
      course = prerequisites[i][0];
      pre = prerequisites[i][1];
      if (lis.get(course) != null) {
        lis.get(course).add(pre);
        res[course]++;
      } else {
        li = new LinkedList<>();
        li.add(pre);
        lis.add(course, li);
        res[course] = 1;
      }
    }

    LinkedList<Integer> dq = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (res[i] == 0) {
        dq.add(i);
      }
//      if (lis.get(i) == null) {
//        dq.add(i);
//        dq.remove(i);
//      }
    }
    LinkedList<Integer> ans = new LinkedList<>();
    while (!dq.isEmpty()) {
      int i = dq.pop();
      ans.addLast(i);
      li = lis.get(i);
      for (int j : li) {
        res[j]--;
        if (res[j] == 0) {
          dq.addLast(j);
        }
      }
    }

    return;
  }
}