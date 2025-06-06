/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graph;

/*
Task: Count the number of island in a char[][] that 1-island, 0-water

*/
public class NumberofIslands {
    int result = 0;
    int[] dx = new int[]{-1, 0, 0, 1};
    int[] dy = new int[]{0, -1, 1, 0};
    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1'){
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int row, int col){
        grid[row][col] = '*';
        for (int i = 0; i < 4; i++){
            int tempR = row + dx[i], tempC = col + dy[i];
            if (isValid(grid, tempR, tempC)){
                dfs(grid, tempR, tempC);
            }
        }
    }

    private boolean isValid(char[][] grid, int row, int col){
        return !(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0' || grid[row][col] == '*');
    }
}
