/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package priorityQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * An ugly number is a positive integer whose prime factors are limited to 2, 3,
 * and 5. Given an integer n, return the nth ugly number.
 */
class Ugly {

    public int[] nums = new int[1690];

    Ugly() {
        nums[0] = 1;
        int ugly, i2 = 0, i3 = 0, i5 = 0;

        //using 3 pointers, if ugly == someone --> increase it.
        for (int i = 1; i < 1690; i++) {
            ugly = Math.min(Math.min(nums[i2] * 2, nums[i3] * 3), nums[i5] * 5);
            nums[i] = ugly;

            if (ugly == nums[i2] * 2) {
                ++i2;
            }
            if (ugly == nums[i3] * 3) {
                ++i3;
            }
            if (ugly == nums[i5] * 5) {
                ++i5;
            }

        }
    }
}

class Solution {

    public static Ugly u = new Ugly();

    public int nthUglyNumber(int n) {
        return u.nums[n - 1];
    }
}
