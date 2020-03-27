public class No999_AvailableCapturesForRook {
//  On an 8 x 8 chessboard, there is one white rook.  There also may be empty squares, white bishops, and black pawns.  These are given as characters 'R', '.', 'B', and 'p' respectively. Uppercase characters represent white pieces, and lowercase characters represent black pieces.
//
//  The rook moves as in the rules of Chess: it chooses one of four cardinal directions (north, east, west, and south), then moves in that direction until it chooses to stop, reaches the edge of the board, or captures an opposite colored pawn by moving to the same square it occupies.  Also, rooks cannot move into the same square as other friendly bishops.
//
//  Return the number of pawns the rook can capture in one move.
  public static void main(String[] args) {
    No999_AvailableCapturesForRook test = new No999_AvailableCapturesForRook();
  }

  public int numRookCaptures(char[][] board) {
    int result = 0;
    int r = 0;
    int c = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] == 'R') {
          r = i;
          c = j;
          break;
        }
      }
    }
    for (int i = r; i >= 0; i--) {
      if (board[i][c] == 'p') {
        result++;
        break;
      } else if (board[i][c] == 'B') {
        break;
      }
    }
    for (int i = r; i < board.length; i++) {
      if (board[i][c] == 'p') {
        result++;
        break;
      } else if (board[i][c] == 'B') {
        break;
      }
    }
    for (int i = c; i < board.length; i++) {
      if (board[r][i] == 'p') {
        result++;
        break;
      } else if (board[r][i] == 'B') {
        break;
      }
    }
    for (int i = c; i >= 0; i--) {
      if (board[r][i] == 'p') {
        result++;
        break;
      } else if (board[r][i] == 'B') {
        break;
      }
    }
    return result;
  }
}
