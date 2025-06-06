/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

/*
Task: Move elements that equal to givenValue to the end of an array
Sol: Using two pointers(one head and one tail)
Time: O(n), Space: 0
 */
public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        //mark the lastIdx that not equal to val
        int rightPointer = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            while (rightPointer >= 0 && nums[rightPointer] == val) {
                rightPointer--;
            }
            if (rightPointer <= i) {
                break;
            }

            if (nums[i] == val) {
                int temp = nums[i];
                nums[i] = nums[rightPointer];
                nums[rightPointer] = temp;
            }
        }
        rightPointer++;
        return rightPointer;
    }

    public static void display(int[] arr, int number) {
        for (int i = 0; i < number; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int valToRemove = 1;
        int remain = removeElement(nums, valToRemove);
        display(nums, remain);
    }
}
