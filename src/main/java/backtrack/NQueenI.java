/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backtrack;

import java.util.ArrayList;
import java.util.List;

/*
Task: The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
Idea: backtrack by row
*/
public class NQueenI {

    private final int n;
    private final List<List<String>> result = new ArrayList<>();

    public NQueenI(int n) {
        this.n = n;
    }

    public List<List<String>> getResult() {
        return result;
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        putQueenBT(board, 0);
        return result;
    }

    private void putQueenBT(char[][] board, int row) {
        if (row == n) {
            result.add(exchange(board));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValidCell(board, row, i)) {
                board[row][i] = 'Q';
                putQueenBT(board, row + 1);
                board[row][i] = '.';
            }
        }
    }

    private boolean isValidCell(char[][] board, int row, int col) {
        if (row < 0 || col < 0 || row >= n || col >= n) {
            return false;
        }
        //check vertical
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        //check above-left
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        //check above-right;
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> exchange(char[][] board) {
        List<String> newRes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            newRes.add(new String(board[i]));
        }
        return newRes;
    }
}
