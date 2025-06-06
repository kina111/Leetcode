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
public class ValidSudoku {

    public ValidSudoku() {
    }

    public boolean isValidSudoku(char[][] board) {
        int[] count = new int[10];

        for (int row = 0; row <= 8; row++) {
            Arrays.fill(count, 0);
            for (int col = 0; col <= 8; col++) {
                char currentChar = board[row][col];
                if (currentChar != '.') {
                    count[currentChar - '0']++;
                    if (count[currentChar - '0'] == 2) {
                        return false;
                    }
                }
            }
        }

        for (int row = 0; row <= 8; row++) {
            Arrays.fill(count, 0);
            for (int col = 0; col <= 8; col++) {
                char currentChar = board[col][row];
                if (currentChar != '.') {
                    count[currentChar - '0']++;
                    if (count[currentChar - '0'] == 2) {
                        return false;
                    }
                }

            }
        }

        for (int rowBase = 0; rowBase < 9; rowBase += 3) {
            for (int colBase = 0; colBase < 9; colBase += 3) {
                Arrays.fill(count, 0);
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        char currentChar = board[rowBase + i][colBase + j];
                        if (currentChar != '.') {
                            int num = currentChar - '1';
                            if (++count[num] > 1) return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSudoku helper = new ValidSudoku();
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(helper.isValidSudoku(board));
    }
}
