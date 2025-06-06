/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

import java.util.Arrays;

/*
Task: Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
You must do it in place.
Sol: Let row0 and col0 as the marker of which row (or col) will be turn into zero
Time: O(n^2) Space: constant
*/
public class SetMatrixZeros {

    public SetMatrixZeros() {
    }
    
    public void setZeroes(int[][] matrix) {
        boolean hang = false, cot = false;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                    if (row == 0) hang = true;
                    if (col == 0) cot = true;
                }
            }
        }
        for (int row = 1; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                for (int col = 0; col < matrix[0].length; col++) {
                    matrix[row][col] = 0;
                }
            }
        }
        for (int col = 1; col < matrix[0].length; col++){
            if (matrix[0][col] == 0){
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = 0;
                }
            }
        }
        
        if (hang) Arrays.fill(matrix[0], 0);
        if (cot){
            for (int[] matrix1 : matrix) {
                matrix1[0] = 0;
            }
        }
    }
    
    public static void main(String[] args) {
        SetMatrixZeros helper = new SetMatrixZeros();
//        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        int[][] matrix = {{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}};
        helper.setZeroes(matrix);
        for (int[] row : matrix){
            System.out.println(Arrays.toString(row));
        }
    }
}
