/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/*
Task: Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
*/
public class PascalTriangleII {
    static List<List<Integer>> pascal = new ArrayList<>();
    static int MAX = 34;
    static{
        for (int i = 0; i < MAX; i++){
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++){
                if (j == 0 || j == i){
                    row.add(1);
                }else{
                    row.add(pascal.get(i-1).get(j-1) + pascal.get(i-1).get(j));
                }
            }
            pascal.add(row);
        }
    }
    public List<Integer> getRow(int rowIndex) {
        return pascal.get(rowIndex);
    }
}
