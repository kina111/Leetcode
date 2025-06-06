/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dynamicProgramming;

/*
Task: Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.
Sol: 
*/
public class MaximumSumCircularSubarray {
    static int MIN = -100000;
    static int MAX = 100000;
    
    //Complexity:  O(n) constant
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int currentSum1 = MIN, maxSum = MIN;
        int currentSum2 = MAX, minSum = MAX;
        for (int i = 0; i < nums.length; i++){
            //find max subarray sum
            currentSum1 = Math.max(nums[i], currentSum1 + nums[i]);
            maxSum = Math.max(currentSum1, maxSum);
            totalSum += nums[i];
              
            //find min subarray sum
            currentSum2 = Math.min(nums[i], currentSum2 + nums[i]);
            minSum = Math.min(currentSum2, minSum);
        }

        //edge case
        if (minSum == totalSum) return maxSum;
        
        //result
        return Integer.max(maxSum, totalSum - minSum);
    }
}
