/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binarySearch;

/*
Task: Seach a number in a matrix[m*n]
Tip: Considering the 2D matrix as an 1D array that (idx / m = column) and (idx % m = row)
*/
public class Searcha2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        return binarySearchMatrix(matrix, m, n, target, 0, m * n - 1);
    }

    private boolean binarySearchMatrix(int[][] matrix, int m, int n, int target, int low, int high) {
        if (low > high) {
            return false;
        }

        int middle = (low + high) / 2;
        if (matrix[middle / n][middle % n] == target) {
            return true;
        }
        if (matrix[middle / n][middle % n] < target) {
            return binarySearchMatrix(matrix, m, n, target, middle + 1, high);
        } else {
            return binarySearchMatrix(matrix, m, n, target, low, middle - 1);
        }
    }
}
