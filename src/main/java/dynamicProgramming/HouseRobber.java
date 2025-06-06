/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dynamicProgramming;

/**
Task: You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
* the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected
* and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        nums[1] = Integer.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++){
            nums[i] = Integer.max(nums[i-1], nums[i-2] + nums[i]);
        }
        return nums[nums.length-1];
    }
}
