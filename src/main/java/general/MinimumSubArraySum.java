/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;
/*
Task: Given an array of positive integers nums and a positive integer target, 
      Return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
Sol: SlidingWindow
Time: O(n) Space: O(1)
Note: should use 1 for-loop and 1 variable instead of controlling two variable in a while-loop
*/
public class MinimumSubArraySum {

    public MinimumSubArraySum() {
    }

    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int start = 0;
        int len = nums.length;
        int currentSum = 0;
        for (int end = 0; end < len; end++) {
            currentSum += nums[end];
            while (currentSum >= target){
                result = Integer.min(result, end-start+1);
                currentSum -= nums[start];
                start++;
            }

        }
        return (result == Integer.MAX_VALUE ? 0 : result);
    }

    public static void main(String[] args) {
        MinimumSubArraySum helper = new MinimumSubArraySum();
        int target = 5;
        int[] nums = {1, 1,1,1};
        System.out.println(helper.minSubArrayLen(target, nums));
    }
}
