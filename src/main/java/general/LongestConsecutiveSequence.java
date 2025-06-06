/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Task: Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
You must write an algorithm that runs in O(n) time
Sol: Using hashSet O(n), O(n)
Idea: Insert int[] into a set and the key is that just care about how many does it increase from a root rather than check the decrease too.
    ---> we iterate each number once ---> O(n)
*/
public class LongestConsecutiveSequence {

    public LongestConsecutiveSequence() {
    }
    
    //Using HashSet with Time: O(n) and Space: O(n)
    public int longestConsecutive1(int[] nums) {
        int longest = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        for (Integer i : set){
            if (!set.contains(i-1)){
                int temp = i+1;
                while (set.contains(temp)){
                    temp++;
                }
                longest = Integer.max(longest, temp - i);
            }
        }
        return longest;
    }
    
    //Using sort with time: O(nlogn) and Space: O(n)-still need new Array to avoid changing input array
    public int longestConsecutive2(int[] nums){
        Arrays.sort(nums);
        int longest = 0;
        int temp = 1;
        if (nums.length == 0) return 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == nums[i-1]) continue;
            if (nums[i] - nums[i-1] == 1){
                temp++;
            }else{
                if (temp > longest) longest = temp;
                temp = 1;
            }
        }
        longest = Integer.max(longest, temp);
        return longest;
    }
    
    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        int[] nums2 = {};
        System.out.println(lcs.longestConsecutive2(nums2));
    }
}
