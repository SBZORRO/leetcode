public class No289_GameOfLife {
//  According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
//
//  Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
//
//      Any live cell with fewer than two live neighbors dies, as if caused by under-population.
//      Any live cell with two or three live neighbors lives on to the next generation.
//      Any live cell with more than three live neighbors dies, as if by over-population..
//      Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
//
//  Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.
//
//  Example:
//
//  Input: 
//  [
//    [0,1,0],
//    [0,0,1],
//    [1,1,1],
//    [0,0,0]
//  ]
//  Output: 
//  [
//    [0,0,0],
//    [1,0,1],
//    [0,1,1],
//    [0,1,0]
//  ]
//
//  Follow up:
//
//      Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
//      In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
//
//  来源：力扣（LeetCode）
//  链接：https://leetcode-cn.com/problems/game-of-life
//  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

  public static void main(String[] args) {
    No289_GameOfLife test = new No289_GameOfLife();
    int[][] temp = new int[][] { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
    System.out.println(temp.toString());
    test.gameOfLife(temp);
    for (int i = 0; i < temp.length; i++) {
      for (int j = 0; j < temp[0].length; j++) {
        System.out.println(temp[i][j]);
      }
    }
  }

  public void gameOfLife(int[][] board) {
    int toLive = 2;
    int toDie = 3;

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        boolean top = i - 1 >= 0;
        boolean prev = j - 1 >= 0;
        boolean next = j + 1 < board[0].length;
        boolean bot = i + 1 < board.length;
        int liveCount = 0;
        int deadCount = 0;
        if (top) {
          if (board[i - 1][j] % 2 == 0) {
            deadCount++;
          } else {
            liveCount++;
          }
        }
        if (prev) {
          if (board[i][j - 1] % 2 == 0) {
            deadCount++;
          } else {
            liveCount++;
          }
        }
        if (bot) {
          if (board[i + 1][j] % 2 == 0) {
            deadCount++;
          } else {
            liveCount++;
          }
        }
        if (next) {
          if (board[i][j + 1] % 2 == 0) {
            deadCount++;
          } else {
            liveCount++;
          }
        }
        if (top && next) {
          if (board[i - 1][j + 1] % 2 == 0) {
            deadCount++;
          } else {
            liveCount++;
          }
        }
        if (bot && next) {
          if (board[i + 1][j + 1] % 2 == 0) {
            deadCount++;
          } else {
            liveCount++;
          }
        }
        if (top && prev) {
          if (board[i - 1][j - 1] % 2 == 0) {
            deadCount++;
          } else {
            liveCount++;
          }
        }
        if (bot && prev) {
          if (board[i + 1][j - 1] % 2 == 0) {
            deadCount++;
          } else {
            liveCount++;
          }
        }

        if (board[i][j] == 1 && liveCount < 2) {
          board[i][j] = 3;
        }
        if (board[i][j] == 1 && (liveCount == 2 || liveCount == 3)) {
          board[i][j] = 1;
        }
        if (board[i][j] == 1 && liveCount > 3) {
          board[i][j] = 3;
        }
        if (board[i][j] == 0 && liveCount == 3) {
          board[i][j] = 2;
        }
      }
    }
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == toDie) {
          board[i][j] = 0;
        }
        if (board[i][j] == toLive) {
          board[i][j] = 1;
        }
      }
    }
  }
}
