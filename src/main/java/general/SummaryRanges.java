/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

import java.util.ArrayList;
import java.util.List;

/*
Task: You are given a sorted unique integer array nums.
A range [a,b] is the set of all integers from a to b (inclusive).
Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
Each range [a,b] in the list should be output as:
"a->b" if a != b
"a" if a == b
*/
public class SummaryRanges {

    public SummaryRanges() {
    }
    
    public List<String> summaryRanges(int[] nums) {
         if (nums.length == 0) return new ArrayList<>();
         List<String> result = new ArrayList<>();
         int idx = 0;
         while (idx < nums.length){
             int start = idx, end = idx+1;
             while (end < nums.length && nums[end] - nums[end-1] == 1){
                 end++;
             }
             end--;
             if (start == end) result.add(Integer.toString(nums[start]));
             else{
                 result.add(nums[start] + "->"+ nums[end]);
             }
             idx = end+1;
         }
         return result;
    }
    
    public static void main(String[] args) {
        SummaryRanges sr = new SummaryRanges();
        int[] nums = {0,1,2,4,5,7};
        System.out.println(sr.summaryRanges(nums));
    }
}
