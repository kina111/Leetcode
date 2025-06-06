/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

/*
Task: Initially positioned at nums[0]. Each element nums[i] represents the maximum length of a forward jump from index i. 
In other words, if you are at nums[i], you can jump to any nums[i + j]
Solution: DP, Greedy
Time: O(n) Space: O(1)/O(n)
Note: Read descriptions carefully and take many examples then try to run
*/
public class Jumpgame2 {
    public static int[] jump(int[] nums) {
        int idx = 1;
        //save the nof steps need to go to that index
        int[] dp = new int[nums.length];
        int remainStepsInCurrentInterval = nums[0];
        int remainStepsForNextInterval = nums[0];
        int stepNeed = 1;
        while (idx < nums.length){
            remainStepsForNextInterval = Integer.max(remainStepsForNextInterval-1, nums[idx]);
            remainStepsInCurrentInterval--;           
            dp[idx] = stepNeed;
            idx++;
            if (remainStepsInCurrentInterval == 0){
                stepNeed++;
                remainStepsInCurrentInterval = remainStepsForNextInterval;
            }
        }
        return dp;
    }
    
    public static void display(int[] dp){
        for (int i = 0; i < dp.length; i++){
            System.out.print("Steps need to go to position " + i + ": ");
            System.out.println(dp[i]);
        }
    }
    public static void main(String[] args) {
        int[] nums = {4,2,1,3,2,3,1,1,2,1,3};
        display(jump(nums));
    }
}
