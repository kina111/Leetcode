/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

import java.util.Arrays;

/*
A template for these interval problems
- Sort intervals/pairs in increasing order of start
- Scan the sorted intervals and maintain an 'active set' for overlapping intervals.
At most times, we don't need to use an explicit set to store all, so that we just need to store some key parameters (like minEnd, cntIntervals, etc)
- If the current set we are checking overlaps with the 'active set' --> update the key parameter
- If not, drop out the 'active set' and create a new one with current interval.
 */
public class MinimumNumberOfArrowsToBurstBallon {

    public MinimumNumberOfArrowsToBurstBallon() {
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int cnt = 0;
        int tempStart = -1;
        int tempEnd = -1;
        for (int[] p : points) {
            if (cnt == 0 || p[0] > tempEnd) {
                cnt++;
                tempEnd = p[1];
                tempStart = p[1];
            } else {
                tempStart = Integer.max(tempStart, p[0]);
                tempEnd = Integer.min(tempEnd, p[1]);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        MinimumNumberOfArrowsToBurstBallon helper = new MinimumNumberOfArrowsToBurstBallon();
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int[][] points2 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int[][] points3 = {{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};
        System.out.println(helper.findMinArrowShots(points3));
    }
}
