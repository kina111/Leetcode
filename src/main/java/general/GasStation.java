/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

/*
Task: There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. 
You begin the journey with an empty tank at one of the gas stations.
(If there exists a solution, it is guaranteed to be unique.)

Idea: gas(A) + gas(B) > cost(C), so if we have checked gasA, we needn't to check gasB
Time: O(n) Space: O(1)
*/
public class GasStation {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int gasRemain = 0;
        for (int i = 0; i < len; i++) {
            gasRemain += gas[i] - cost[i];
        }
        //if total gas is not equal or greater than total cost at first
        if (gasRemain < 0) return -1;
        
        //else, there is a satisfied index
        gasRemain = 0;
        int idxResult = -1;
        for (int idx = 0; idx < len; idx++){
            //not set an idx to check yet
            if (idxResult == -1){
                if ((gas[idx] - cost[idx]) >= 0){
                    gasRemain = gas[idx] - cost[idx];
                    idxResult = idx;
                }
            //on checking an idx
            }else{
                gasRemain += gas[idx] - cost[idx];
                if (gasRemain < 0) {
                    idxResult = -1;
                }
            }         
        }
        return idxResult;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(String.format("GasIndex to start: %d", canCompleteCircuit(gas, cost)));
    }
}
