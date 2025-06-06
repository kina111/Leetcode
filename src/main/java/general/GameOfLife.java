/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

import java.util.Arrays;

/*
Task: Given a 2D board with cell value is 0(dead), 1(live) and some rules:
    1. Any live cell with fewer than two live neighbors dies as if caused by under-population.
    2. Any live cell with two or three live neighbors lives on to the next generation.
    3. Any live cell with more than three live neighbors dies, as if by over-population.
    4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
note that In this process, births and deaths occur simultaneously.

Sol: present dead->live: 2 and live->dead: 3 --> one number can represent many meanings (not just live, dead in this problem)
Time: O(m*n) Space: constant
*/
public class GameOfLife {

    public GameOfLife() {
    }

    public int countLivesSurrounding(int[][] board, int m, int n, int row, int col) {
        int result = 0;
        int tempR, tempC;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                tempR = row + i;
                tempC = col + j;
                if (tempR >= 0 && tempR < m && tempC >= 0 && tempC < n && (board[tempR][tempC] == 1 || board[tempR][tempC] == 3)) {
                    result++;
                }
            }
        }
        return result;
    }

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int cntTemp = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cntTemp = countLivesSurrounding(board, m, n, i, j);
                if (board[i][j] == 1 && (cntTemp < 2 || cntTemp > 3)) {
                    board[i][j] = 3;
                }
                if (board[i][j] == 0 && cntTemp == 3) {
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
                if (board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        GameOfLife gol = new GameOfLife();
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gol.gameOfLife(board);
        for (int[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }

}
