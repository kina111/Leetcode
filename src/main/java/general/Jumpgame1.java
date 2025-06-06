/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

/*
Task: Initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
Return true if you can reach the last index, or false otherwise.
Sol: Greedy
Time: O(n) Space: O(1)
*/
public class Jumpgame1 {
    public static boolean canJump(int[] nums) {
        int stepRemain = 0;
        for (int i = 0; i < nums.length; i++){
            stepRemain = Integer.max(stepRemain-1, nums[i]);
            if (stepRemain == 0 && i <= nums.length - 2){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums));
    }
}
