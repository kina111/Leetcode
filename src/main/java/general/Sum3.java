/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author FPT
 */
public class Sum3 {

    public Sum3() {
    }

    public List<List<Integer>> findAllCasesWithOneGivenNumber(int[] nums, int target, int firstNum, int from, int to) {
        List<List<Integer>> res = new ArrayList<>();
        int sumOfTwoRemains = target - firstNum;
        int previousFrom = Integer.MIN_VALUE;
        while (from < to) {
            //check second condition to avoid duplicate
            if (nums[from] + nums[to] == sumOfTwoRemains && nums[from] != previousFrom) {
                res.add(Arrays.asList(firstNum, nums[from], nums[to]));
                previousFrom = nums[from];
                from++; to--;
            } else if (nums[from] + nums[to] < sumOfTwoRemains) {
                from++;
            } else {
                to--;
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i <= len - 3; i++) {
            //if equal, don't need to process again
            if (i >= 1 && nums[i] == nums[i-1]) continue;
            //else
            List<List<Integer>> currentGroups = findAllCasesWithOneGivenNumber(nums, 0, nums[i], i+1, len-1);
            res.addAll(currentGroups);
        }
        return res;
    }

    public static void displayList(List<Integer> l) {
        System.out.print("[");
        for (int i = 0; i < l.size() - 1; i++) {
            System.out.print(l.get(i) + ", ");
        }
        System.out.println(l.get(l.size() - 1) + "]");
    }

    public static void main(String[] args) {
        Sum3 sum3 = new Sum3();
        int[] nums = {-1,-1,0,1};
        List<List<Integer>> res = sum3.threeSum(nums);
        for (List<Integer> l : res) {
            displayList(l);
        }
    }
}
