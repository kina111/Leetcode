/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binarySearch;

import java.util.Arrays;

/**
 * Task: Given an integer array nums[], choose p pairs so that the maximum in these differences is the smalles.
 * eg: [10,1,2,7,1,3] with p=2. So choose [1,1], [2,3] ---> 1
 * 
 * Sol: Naive: iterate the difference from 1 to MAX, for each value, count the number of satisfied pairs
 *      --> use binarySearch to improve.
 */
public class MinimizeTheMaximumDifferenceOfPairs {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length, left = 0, right = nums[n-1] - nums[0];

        while (left < right){
            int mid = (left + right) / 2, k = 0;
            for (int i = 1; i < n && k < p; i++){
                if (nums[i] - nums[i-1] >= mid){
                    k++; i++;
                }
            }
            if (k >= p) right = mid-1;
            else left = mid;
        }
        return left;
    }
}
