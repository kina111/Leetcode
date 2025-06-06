/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dynamicProgramming;

/*
Task: You are given an integer array values where values[i] represents the value of the ith sightseeing spot.
Two sightseeing spots i and j have a distance j - i between them.
The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + i - j: the sum of the values of the sightseeing spots, minus the distance between them.
Return the maximum score of a pair of sightseeing spots.

Sol: Greedy take the most optimal value from left + DP
 */
public class BestSightseeingPair {

    public int maxScoreSightseeingPair(int[] values) {
        int prev = values[0];
        int result = -1;
        for (int i = 1; i < values.length; i++) {
            result = Math.max(result, prev - 1 + values[i]);
            prev = Math.max(prev - 1, values[i]);
        }
        return result;
    }
}
