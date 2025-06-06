/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binarySearch;

/**
Task: Given an array of integers nums sorted in non-decreasing order, 
    Find the starting and ending position of a given target value.
    If target is not found in the array, return [-1, -1].
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    
    public int[] searchRange(int[] nums, int target) {
        //store the result
        int[] result = new int[2];
        result[0] = result[1] = -1;
        
        
        //find an random idx of target
        int firstFindIdx = find(nums, target, 0, nums.length-1);

        //if target does not exist
        if (firstFindIdx == -1) return result;

        //normal case
        result[0] = result[1] = firstFindIdx;
        int low, high;
        int firstTemp = firstFindIdx;
        low = 0; high = firstFindIdx-1;
        while (low <= high && firstTemp != -1){
            firstTemp = find(nums, target, low, high);
            if (firstTemp != -1) result[0] = firstTemp;
            high = firstTemp-1;
        }

        int lastTemp = firstFindIdx;
        low = firstFindIdx+1; high = nums.length-1;
        while (low <= high && lastTemp != -1){
            lastTemp = find(nums, target, low, high);
            if (lastTemp != -1) result[1] = lastTemp;
            low = lastTemp+1;
        }
        
        return result;
    }
    private int find(int[] nums, int target, int low, int high){
        if (low > high) return -1;
        int middle = (low + high) / 2;
        if (nums[middle] == target) return middle;
        if (nums[middle] < target) return find(nums, target, middle+1, high);
        return find(nums, target, low, middle-1);
    }
}
