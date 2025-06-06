/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dynamicProgramming;

/*
Task: You are given an m x n integer matrix points (0-indexed). 
Starting with 0 points, you want to maximize the number of points you can get from the matrix.
To gain points, you must pick one cell in each row. Picking the cell at coordinates (r, c) will add points[r][c] to your score.
However, you will lose points if you pick a cell too far from the cell that you picked in the previous row.
    For every two adjacent rows r and r + 1 (where 0 <= r < m - 1), picking cells at coordinates (r, c1) and (r + 1, c2) will subtract abs(c1 - c2) from your score.
Return the maximum number of points you can achieve.
Find the maximum point you can get.

Sol: Can take the idea of "BestSightseeingPair"
*/
public class MaximumNumberOfPointsWithCost {
    public long maxPoints(int[][] points) {
        int m = points.length, n = points[0].length;
        long[] prev = new long[n];
        long[] l = new long[n];
        long[] r = new long[n];

        for (int i = 0; i < n; i++) prev[i] = points[0][i];

        for (int i = 1; i < m; i++) {
            l[0] = prev[0];
            //update l
            for (int j = 1; j < n; j++) {
                l[j] = Math.max(prev[j], l[j - 1] - 1);
            }
            //update r
            r[n - 1] = prev[n - 1];
            for (int j = n - 2; j >= 0; j--) {
                r[j] = Math.max(prev[j], r[j + 1] - 1);
            }
            //update prev with current row
            for (int j = 0; j < n; j++) {
                prev[j] = Math.max(l[j], r[j]) + points[i][j];
            }
        }

        long res = 0;
        for (long val : prev) res = Math.max(res, val);
        return res;
    }
}
