/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binaryTreeBFS;

import java.util.LinkedList;
import java.util.Queue;

/*
Task: You have n boxes labeled from 0 to n - 1. You are given four arrays: status, candies, keys, and containedBoxes where:
    + status[i] is 1 if the ith box is open and 0 if the ith box is closed,
    + candies[i] is the number of candies in the ith box,
    + keys[i] is a list of the labels of the boxes you can open after opening the ith box.
    + containedBoxes[i] is a list of the boxes you found inside the ith box.
You are given an integer array initialBoxes that contains the labels of the boxes you initially have. You can take all the candies in any open box and you can use the keys in it to open new boxes and you also can use the boxes you find in it.
Return the maximum number of candies you can get following the rules above.

Sol: Using BFS
*/
public class MaximumsCandiesYouGetFromBoxed {

    //Complexity: O(n)-as each box is opened at most 1 time
    //            O(n)
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int res = 0;
        int n = status.length;

        boolean[] hasKey = new boolean[n];
        Queue<Integer> availableBoxes = new LinkedList<>();

        for (int box : initialBoxes) {
            availableBoxes.offer(box);
        }

        boolean changed = true;

        while (changed) {
            int size = availableBoxes.size();
            changed = false;

            for (int i = 0; i < size; i++) {
                int box = availableBoxes.poll();

                if (status[box] == 1 || hasKey[box]) {
                    // Đánh dấu có sự thay đổi
                    changed = true;

                    // Lấy kẹo
                    res += candies[box];

                    // Mở các hộp con
                    for (int childBox : containedBoxes[box]) {
                        availableBoxes.offer(childBox);
                    }

                    // Nhặt các chìa khóa
                    for (int key : keys[box]) {
                        hasKey[key] = true;
                    }

                    // Đánh dấu hộp đã mở
                    status[box] = 1;
                } else {
                    // Hộp chưa mở được → đợi key
                    availableBoxes.offer(box);
                }
            }
        }

        return res;
    }
}
