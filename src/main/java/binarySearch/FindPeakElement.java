/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binarySearch;

/**
Task: Given an array. find index that its value is greater than both neighbors.
*   Return one result.
 */
public class FindPeakElement {
    //to mark if find one peak element
    int res = -1;

    public int findPeakElement(int[] nums) {
        //edge cases
        if (nums.length == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        
        //general case
        binaryFind(nums, 1, nums.length - 2);

        return res;
    }

    private void binaryFind(int[] nums, int low, int high) {
        if (res != -1) {
            return;
        }
        if (low > high) {
            return;
        }

        int middle = (low + high) / 2;
        if (nums[middle] > nums[middle - 1] && nums[middle] > nums[middle + 1]) {
            res = middle;
            return;
        }
        //search on both sides and will terminate immediately when finding one peak element.
        binaryFind(nums, low, middle - 1);
        binaryFind(nums, middle + 1, high);
    }
}
