/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Task: Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, 
and return an array of the non-overlapping intervals that cover all the intervals in the input.
Sol: O(n)-O(n)
Note: Trying to think and solve in one side that each step should do one thing (like compare with the previous or the following instead of both)
--> Solving each small step concisely to avoid edge case and many if ocnditions.
 */
public class MergeIntervals {

    public MergeIntervals() {
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));  // Sort theo start

        int[][] result = new int[intervals.length][2];  // Kết quả tạm
        int cnt = -1;

        for (int idx = 0; idx < intervals.length; idx++) {
            if (cnt == -1 || intervals[idx][0] > result[cnt][1]) {
                // Không giao nhau → tạo khoảng mới
                cnt++;
                result[cnt] = new int[]{intervals[idx][0], intervals[idx][1]};
            } else {
                // Giao nhau → gộp
                result[cnt][1] = Math.max(result[cnt][1], intervals[idx][1]);
            }
        }

        return Arrays.copyOf(result, cnt + 1);  // Cắt phần thừa
    }
    
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int idx = 0;
        // add all the intervals ending before newInterval starts
        while (idx < intervals.length && intervals[idx][1] < newInterval[0]) {
            result.add(intervals[idx]);
            idx++;
        }
        // merge all overlapping intervals to one considering newInterval
        while (idx < intervals.length && intervals[idx][0] <= newInterval[1]) {
            newInterval[0] = Integer.min(newInterval[0], intervals[idx][0]);
            newInterval[1] = Integer.max(newInterval[1], intervals[idx][1]);
            idx++;
        }
        // add the union of intervals we got
        result.add(newInterval);
        // add all the rest
        while (idx < intervals.length) {
            result.add(intervals[idx]);
            idx++;
        }
        return result.toArray(int[][]::new);
    }

    public static void main(String[] args) {
        MergeIntervals mi = new MergeIntervals();
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};

        int[][] result = mi.insert(intervals, newInterval);
        for (int[] re : result) {
            System.out.println(Arrays.toString(re));
        }
    }
}
