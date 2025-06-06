/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Task: Generate all permutation of a int[]
 */
public class Permutation {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> exchange = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            exchange.add(nums[i]);
        }
        backtrack(exchange, 0);
        return result;
    }

    private void backtrack(List<Integer> nums, int idx) {
        if (idx == nums.size()) {
            result.add(new ArrayList<>(nums));
            return;
        }
        for (int i = idx; i < nums.size(); i++) {
            Collections.swap(nums, idx, i);
            backtrack(nums, idx + 1);
            Collections.swap(nums, idx, i);
        }
    }
}
