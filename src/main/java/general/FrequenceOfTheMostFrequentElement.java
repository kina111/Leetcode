/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

import java.util.Arrays;

/**
Task: The frequency of an element is the number of times it occurs in an array.
* You are given an integer array nums and an integer k.
* In one operation, you can choose an index of nums and increment the element at that index by 1.
* Return the maximum possible frequency of an element after performing at most k operations
* 
* Sol: Using greedy + Sliding window
*/
public class FrequenceOfTheMostFrequentElement {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, result = 0;
        long total = 0;

        for (int r = 0; r < nums.length; r++) {
            total += nums[r];
            // Tính số bước cần thiết để biến tất cả từ l đến r thành nums[r]
            while ((long) nums[r] * (r - l + 1) - total > k) {
                total -= nums[l];
                l++;
            }
            result = Math.max(result, r - l + 1);
        }

        return result;
    }
}
