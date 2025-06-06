/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

/*
Task: Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
Sol: 1. Rotate array 1 step ahead for k times --- Time: O(n^2), Space: O(1)
     2. Create an new array to store --- Time: O(n), Space: O(n)
     3. Use reverse 3 times --- Time: O(n), Space: O(1)
        (as we see that there are two blocks that its elements always go together).
 */
class RotateArray {

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void rotate(int[] nums, int timesForRotate) {
        int length = nums.length;
        timesForRotate = timesForRotate % length;
        if (timesForRotate == 0) {
            return;
        }
        reverse(nums, 0, length - 1);
        reverse(nums, 0, timesForRotate - 1);
        reverse(nums, timesForRotate, length - 1);
    }

    
    public static void display(int[] arr, int number) {
        System.out.print("[");
        for (int i = 0; i < number; i++) {
            System.out.print(arr[i]);
            if (i < number - 1) {
                System.out.print(", ");
            } else {
                System.out.println("]");
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        int timeForRotate = 3;
        rotate(nums, timeForRotate);
        display(nums, nums.length);
    }
}
