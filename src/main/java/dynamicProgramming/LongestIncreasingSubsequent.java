/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Task: Given an integer array nums, return the length of the longest strictly increasing subsequence.
Sol: 
    Using DP: DP[i] = max(dp[j], 0 <= j < i) + 1
    Using greedy
*/
public class LongestIncreasingSubsequent {

    //Using DP Time: O(n^2) Space: O(n)
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int result = 1;


        for (int i = 1; i < len; i++){
            for (int j = 0; j < i; j++){
                if (nums[j] < nums[i] && dp[j] >= dp[i]) dp[i] = dp[j]+1;
            }
            if (dp[i] > result) result = dp[i];
        }
        return result;

    }
    
    //Using greedy Time: O(nlogn) Space: O(n)
    public int lengthOfLIS2(int[] nums) {
        int len = nums.length;
        List<Integer> path = new ArrayList<>();
        path.add(nums[0]);
        
        for (int i = 1; i < len; i++) {
            //if current number is greater than the last element of path, add it 
            if (nums[i] > path.get(path.size() - 1)) {
                path.add(nums[i]);
             
            } else {//else, replace the smallest element that is greater than or equal to current number with current number
                int replaceIdx = lowerBound(path, nums[i]);
                path.set(replaceIdx, nums[i]);
            }
        }
        return path.size();
    }

    private int lowerBound(List<Integer> path, int num) {
        int l = 0, r = path.size(); // r = size, not size - 1
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (path.get(mid) < num) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
