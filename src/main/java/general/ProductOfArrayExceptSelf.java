/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

import java.util.Arrays;

/**
 * Task: Given an integer array nums, return an array answer such that answer[i]
 * is equal to the product of all the elements of nums except nums[i]. Write an
 * algorithm that runs in O(n) time and without using the division operation.
 * Sol: 1. Use 2 int[] prefix and suffix Time: O(n) Space: O(n)
 *      2. Reusing the inputArray and outputArray so Space is O(1) --- not prefer
 */
public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] answer = new int[len];
        int[] prefix = new int[len];
        int[] suffix = new int[len];
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                prefix[i] = suffix[i] = 1;
            } else {
                prefix[i] = prefix[i - 1] * nums[i - 1];
                suffix[i] = suffix[i - 1] * nums[len - i];
            }
        }
        for (int i = 0; i < len; i++) {
            answer[i] = prefix[i] * suffix[len - 1 - i];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}
