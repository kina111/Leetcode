/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package divideAndConquer;

/*
Task: Given an integer array nums, find the subarray with the largest sum, and return its sum.
 */
public class MaximumSubarray {

    //O(n) solution with greedy
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int currentSum = 0;
        boolean isTotalNegative = true;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                isTotalNegative = false;
            }
            if (nums[i] > res) {
                res = nums[i];
            }
            currentSum += nums[i];
            if (currentSum < 0) {
                currentSum = 0;
            } else if (currentSum > res && !isTotalNegative) {
                res = currentSum;
            }
        }
        return res;
    }
    
    //kadane's algorithm: more subtle
    public int maxSubArray2(int[] nums) {
        int currentSum = nums[0], maxSum = nums[0];
        for (int i = 1; i < nums.length; i++){
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }
}
