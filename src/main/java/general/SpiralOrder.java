/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

import java.util.ArrayList;
import java.util.List;

/*
Task: Given an m x n matrix, return all elements of the matrix in spiral order.
Sol: Handing boundary and give a clear and concise solution
*/
public class SpiralOrder {

    public SpiralOrder() {
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int nofRow = matrix.length;
        int nofCol = matrix[0].length;
        int startCell = 0;

        while (nofRow > 0 && nofCol > 0) {
            for (int i = startCell; i <= startCell + nofCol - 1; i++) {
                result.add(matrix[startCell][i]);
            }
            for (int i = startCell + 1; i <= startCell + nofRow - 1; i++) {
                result.add(matrix[i][startCell + nofCol - 1]);
            }
            if (nofRow > 1) { // not to add duplicate with first loop
                for (int i = startCell + nofCol - 2; i >= startCell; i--) {
                    result.add(matrix[startCell + nofRow - 1][i]);
                }
            }
            if (nofCol > 1) { // not to add duplicate with second loop
                for (int i = startCell + nofRow - 2; i >= startCell + 1; i--) {
                    result.add(matrix[i][startCell]);
                }
            }

            nofRow -= 2;
            nofCol -= 2;
            startCell++;
        }
        return result;
    }

    public static void main(String[] args) {
        SpiralOrder helper = new SpiralOrder();
        int[][] matrix = {{6,7,9}};
        List<Integer> result = helper.spiralOrder(matrix);
        System.out.println(result.toString());
    }
}
