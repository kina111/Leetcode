/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binarySearch;

/**
Task: Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
    [4,5,6,7,0,1,2] if it was rotated 4 times.
    [0,1,2,4,5,6,7] if it was rotated 7 times.
Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        //edge case: if does not rotate
        if (nums[0] <= nums[nums.length-1]) return nums[0];
        
        
        int low = 0, high = nums.length-1;
        //find two adjacent idx that the previous is bigger than the after.
        while (high - low != 1){
            int mid = low + (high - low) / 2;//avoid overflow when low, high is too big.
            if (nums[mid] > nums[nums.length-1]) low = mid;
            else if (nums[mid] < nums[nums.length-1]) high = mid;
        }
        return nums[low+1];
    }
}
