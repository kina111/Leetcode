/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dynamicProgramming;

import java.util.Arrays;
/*
Task: Given an int[][] rides with rides[i] = {start, end, tip}
* Return the max earnings, that the taxi can't change direction to go back.
*
* Sol: Quite similar to jobScheduling with profit.
* At each rides ith, we have two options:
*   1. Take that trip: dp[i] = tip[i] + dp[lastestNotConflict]
*   2. Not take that trip; dp[i] = dp[i-1];
*   and dp[i] = max(option1, option 2).
* Time: O(nlogn) Space: O(n)
*/
public class MaximumEarningFromTaxi {
    public long maxTaxiEarnings(int n, int[][] rides) {
        int nofDrive = rides.length;

        Arrays.sort(rides, (a, b) -> a[1] - b[1]); // sort by endTime
        long[] dp = new long[nofDrive]; //store the max earnings when choose from job 0-i
        Arrays.fill(dp, 0);
        dp[0] = rides[0][1] - rides[0][0] + rides[0][2];
        
        for (int i = 1; i < nofDrive; i++){
            long earning = rides[i][1] - rides[i][0] + rides[i][2];
            int idx = findLastNotConflictJob(rides, i);
            if (idx != -1){
                earning += dp[idx];
            }
            dp[i] = Math.max(dp[i-1], earning);
        }
        return dp[nofDrive-1];
    }

    private int findLastNotConflictJob(int[][] rides, int idx){
        int low = 0, high = idx-1;
        while (low <= high){
            int mid = low + (high-low)/2;
            if (rides[mid][1] <= rides[idx][0]){
                if (rides[mid+1][1] <= rides[idx][0]){
                    low = mid+1;
                }else{
                    return mid;
                }
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
    
}
