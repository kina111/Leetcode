/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

/*
Task: Remove duplicates in a sortedArray, just store up to 2 similar element for each value
Sol: Using two pointers
Complex: Time O(n), Space O(1)
*/
public class RemoveDuplicatedFromSortedArray2 {
    public static int removeDuplicates(int[] nums) {
        int idxLastUniqueElement = 0;
        boolean canAddDuplicate = true;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != nums[idxLastUniqueElement]){
                nums[++idxLastUniqueElement] = nums[i];
                canAddDuplicate = true;
            }else{
                if (idxLastUniqueElement >= i || !canAddDuplicate){
                    continue;
                }
                nums[++idxLastUniqueElement] = nums[i];
                canAddDuplicate = false;
            }         
        }
        return idxLastUniqueElement+1;
    }
    
     public static void display(int[] arr, int number) {
         System.out.print("[");
        for (int i = 0; i < number; i++) {
            System.out.print(arr[i]);
            if (i < number-1) System.out.print(", ");
            else System.out.println("]");
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        int remain = removeDuplicates(nums);
        display(nums, remain);
    }
}
