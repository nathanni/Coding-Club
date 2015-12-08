package com.nathan.leetcode.easy;

/*Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.*/

public class ValidSudoku {

  public static void main(String[] args) {

  }

  // sudoku is 9 * 9   use bit manipulation
  public boolean isValidSudoku(char[][] board) {

    for (int i = 0; i < 9; i++) {
      int checkerForRow = 0;
      int checkerForColumn = 0;
      int checkerForBox = 0;
      for (int j = 0; j < 9; j++) {

        int posForRow = board[i][j] - '1';
        if (board[i][j] != '.' && (checkerForRow & (1 << posForRow)) > 0) {
          return false;
        }
        checkerForRow |= 1 << posForRow;

        int posForColumn = board[j][i] - '1';
        if (board[j][i] != '.' && (checkerForColumn & (1 << posForColumn)) > 0) {
          return false;
        }
        checkerForColumn |= 1 << posForColumn;


       //要搞清楚 i j 和box里 i j 的关系， 难点在这
        int boxRowIndex = i / 3 * 3;
        int boxColumnIndex = i % 3 * 3;
        int posForBox = board[boxRowIndex + j / 3][boxColumnIndex + j % 3] - '1';
        if (board[boxRowIndex + j / 3][boxColumnIndex + j % 3] != '.' && (checkerForBox & (1 << posForBox)) > 0) {
          return false;
        }
        checkerForBox |= 1 << posForBox;
      }
    }
    return true;
  }

}
