/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graph;

/*
Task: Like the XO game in childhood.
    Turn O into X if it is surrounded by X in-place
eg: input=
[["O","X","X","O","X"],
["X","O","O","X","O"],
["X","O","X","O","X"],
["O","X","O","O","O"],
["X","X","O","X","O"]]

expect =
[["O","X","X","O","X"],
["X","X","X","X","O"],
["X","X","X","O","X"],
["O","X","O","O","O"],
["X","X","O","X","O"]]

Sol: Iterating all border cells that if it is O: using dfs to save all O connecting with it.
Time: O(n) Space: in-place
*/
public class SurroundedRegions {

    int[] dx = {-1, 0, 0, 1};
    int[] dy = {0, -1, 1, 0};

    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][cols - 1] == 'O') {
                dfs(board, i, cols - 1);
            }
        }

        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[rows - 1][j] == 'O') {
                dfs(board, rows - 1, j);
            }
        }

        // Đổi lại các ô
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != 'O') {
            return;
        }

        board[row][col] = 'T';
        for (int i = 0; i < 4; i++) {
            dfs(board, row + dx[i], col + dy[i]);
        }
    }
}
