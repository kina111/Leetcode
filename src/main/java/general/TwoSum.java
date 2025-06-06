/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

import java.util.HashMap;

/*
Task: Find the index of two number in an array that their sum is equal to target.
Sol: using hashmap<value, index> and for each index, check whether there is the remain number in hashmap
*/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++){
            //if hash already has the remain number
            if (map.containsKey(target - nums[i])){
                res[0] = i; res[1] = map.get(target - nums[i]);
                break;
            }
            //if not, add to hash
            map.put(nums[i], i);
        }
        // for (int i = 0; i < nums.length; i++){
        //     if (map.containsKey(target - nums[i])){
        //         if (map.get(target - nums[i]) != i){
        //             res[0] = i; res[1] = map.get(target- nums[i]);
        //             break;
        //         }
        //     }
        // }
        return res;
    }
}
