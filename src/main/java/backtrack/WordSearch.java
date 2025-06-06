/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backtrack;

/*
Task: Given an m x n grid of characters board and a string word, return true if word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

Time: O(m*n*4^l) Space: O(m*n) cho visited[][]
*/
public class WordSearch {

    class Solution {

        static int[] dx = {-1, 1, 0, 0}; // hướng dọc: lên, xuống
        static int[] dy = {0, 0, -1, 1}; // hướng ngang: trái, phải
        boolean[][] visited = new boolean[7][7];

        public boolean exist(char[][] board, String word) {
            int m = board.length;
            int n = board[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == word.charAt(0) && !visited[i][j]) {
                        visited[i][j] = true;
                        if (backtrack(board, word, 0, i, j)) {
                            return true;
                        }
                        visited[i][j] = false;
                    }
                }
            }
            return false;
        }

        private boolean backtrack(char[][] board, String word, int idxInWord, int x, int y) {
            if (idxInWord == word.length() - 1 && board[x][y] == word.charAt(idxInWord)) {
                return true;
            }
            if (board[x][y] != word.charAt(idxInWord)) {
                return false;
            }
            for (int i = 0; i <= 3; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if (backtrack(board, word, idxInWord + 1, nx, ny)) {
                        return true;
                    }
                    visited[nx][ny] = false;
                }
            }
            return false;
        }
    }
}
