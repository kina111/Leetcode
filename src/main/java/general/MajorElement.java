/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

/*
Task: Given an array with n elements. The majority element is the element that appears more than ⌊n / 2⌋ times.
      Return the major element.
Sol: Moore Voting algorithm
Complex: Time O(n) Space O(1)
*/
public class MajorElement {
    public static int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        int idea = nums[0];
        int vote = -1;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == idea){
                vote++;
            }else{
                vote--;
            }
            if (vote == 0){
                vote = 1;
                idea = nums[i];
            }
        }
        return idea;
    }
    public static void main(String[] args) {
        int[] ideas = {3, 3, 4};
        System.out.println(majorityElement(ideas));
    }
}
