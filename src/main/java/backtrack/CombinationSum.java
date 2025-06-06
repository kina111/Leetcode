/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backtrack;

import java.util.ArrayList;
import java.util.List;

/*
Task: Given an int[] candidates
    Return all set having sum equal to a given target
eg: candidate={2,3,6,7}; target = 8 ---> {2,2,2,2}, {2,3,3}, {2,6}
*/
public class CombinationSum {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> curr = new ArrayList<>();
        backtrack(curr, target, 0, candidates);
        return result;
    }

    private void backtrack(List<Integer> curr, int remaining, int nextIdx, int[] candidates){
        if (remaining == 0){
            result.add(new ArrayList<>(curr));
            return;
        }
        if (remaining < 0) return;

        for (int i = nextIdx; i < candidates.length; i++){
            curr.add(candidates[i]); remaining -= candidates[i];
            backtrack(curr, remaining, i, candidates);
            curr.remove(curr.size()-1); remaining += candidates[i];
        }
    }
}
