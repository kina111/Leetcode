/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dynamicProgramming;

/*
Task: Find the number of ways to go from top-left to bottom-right of a grid m*n, such that there are obstacle-'1' and freeSpace-'0' on grid
Sol: Using dp with obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];

*/
public class UniquePathII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length, cols = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) return 0;
        obstacleGrid[0][0] = 1;
        
        for (int row = 1; row < rows; row++) {
            obstacleGrid[row][0] = (obstacleGrid[row][0] == 0 && obstacleGrid[row-1][0] == 1) ? 1 : 0;
        }

        // Initialize first row
        for (int col = 1; col < cols; col++) {
            obstacleGrid[0][col] = (obstacleGrid[0][col] == 0 && obstacleGrid[0][col-1] == 1) ? 1 : 0;
        }

        for (int i = 1; i < rows; i++){
            for (int j = 1; j < cols; j++){
                if (obstacleGrid[i][j] == 1){
                    obstacleGrid[i][j] = 0;
                }else{
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                }
            }
        }
        return obstacleGrid[rows-1][cols-1];
    }
}
