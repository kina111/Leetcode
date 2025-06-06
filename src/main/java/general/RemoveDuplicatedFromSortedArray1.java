/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

/*
Task: Remove duplicates in a sortedArray
Sol: Using two pointers
Complex: Time O(n), Space O(1)
*/
class RemoveDuplicatedFromSortedArray1 {

    public static int removeDuplicates(int[] nums) {
        //store the lastIndex of unique array
        int idxLastUniqueElement = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[idxLastUniqueElement]) {
                nums[++idxLastUniqueElement] = nums[i];
            }
        }
        return idxLastUniqueElement + 1;
    }

    public static void display(int[] arr, int number) {
        for (int i = 0; i < number; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 4, 4, 5};
        int remain = removeDuplicates(nums);
        display(nums, remain);
    }
}
