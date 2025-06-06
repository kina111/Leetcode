/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

/*
Task: Given n non-negative integers representing an elevation map where the width of each bar is 1,
    Compute how much water it can trap after raining.
Sol: Greedy
Idea: In each wall, just care about the heighest wall to the left and right (include itself) 
Time+Space: O(n)
*/
public class TrappingRainWater {
    public int trap(int[] height) {
        int len = height.length;
        int[] maxFromLeft = new int[len]; int currentLeftMax = 0;
        int[] maxFromRight = new int[len]; int currentRightMax = 0;
        maxFromLeft[0] = height[0]; maxFromRight[len-1] = height[len-1];
        for (int i = 1; i < len; i++){
            maxFromLeft[i] = Integer.max(maxFromLeft[i-1], height[i]);
        }
        for (int i = len-2; i >= 0; i--){
            maxFromRight[i] = Integer.max(maxFromRight[i+1], height[i]);
        }
        int result = 0;
        for (int i = 0; i < len; i++){
            int store = Integer.min(maxFromLeft[i], maxFromRight[i]) - height[i];
            result += store;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        TrappingRainWater solution = new TrappingRainWater();
        System.out.println(solution.trap(height));
    }
}
