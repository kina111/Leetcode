/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

import java.util.Arrays;

/**
 *
 * @author FPT
 */
public class RotateImage {

    public RotateImage() {
    }

    public void reverseRow(int[][] matrix, int row) {
        int nofCol = matrix[0].length;
        for (int i = 0; i < nofCol / 2; i++) {
            int temp = matrix[row][i];
            matrix[row][i] = matrix[row][nofCol - i - 1];
            matrix[row][nofCol - i - 1] = temp;
        }
    }

    public void rotate(int[][] matrix) {
        int nofRow = matrix.length;
        int nofCol = matrix[0].length;
        for (int i = 0; i < nofRow; i++) {
            for (int j = 0; j <= i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int row = 0; row < nofRow; row++) {
            reverseRow(matrix, row);
        }
    }
    
    public static void main(String[] args) {
        RotateImage helper = new RotateImage();
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        helper.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
