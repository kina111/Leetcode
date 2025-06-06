/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graph;

import java.util.*;

/*
Task: A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.
    Suppose we need to investigate a mutation from a gene string startGene to a gene string endGene where one mutation is defined as one single character changed in the gene string.
    There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.
Given the two gene strings startGene and endGene and the gene bank bank, return the minimum number of mutations needed to mutate from startGene to endGene. 
If there is no such a mutation, return -1. 

Sol: Using backtrack (quite similar to dfs)
    (when encounter a new gene, we scan all its mutateGene
Time: O(n!)
*/
public class MinimumGeneticMutation {

    int res = -1;

    public int minMutation(String startGene, String endGene, String[] bank) {
        // a visitedMap to make sure when on a specific mutation path, it dont make a circle (to avoid stackoverflow)
        Map<String, Boolean> map = new HashMap<>();
        for (String bank1 : bank) {
            map.put(bank1, false);
        }
        
        String currentGene = startGene;
        int nofSteps = 0;
        dfs(currentGene, endGene, bank, map, nofSteps);
        return res;
    }

    private void dfs(String currentGene, String endGene, String[] bank, Map<String, Boolean> map, int nofSteps) {
        //base case
        if (currentGene.equals(endGene)) {
            if (res == -1 || res > nofSteps) {
                res = nofSteps;
            }
            return;
        }

        //for all gene that can be mutate to
        for (String bank1 : bank) {
            if (map.get(bank1) == false && isDiffer1(currentGene, bank1)) {
                map.put(bank1, true);
                dfs(bank1, endGene, bank, map, nofSteps + 1);
                map.put(bank1, false);
            }
        }

    }

    private boolean isDiffer1(String fromGene, String toGene) {
        int nofDiff = 0;
        for (int i = 0; i < 8; i++) {
            if (fromGene.charAt(i) != toGene.charAt(i)) {
                nofDiff++;
            }
        }
        return nofDiff == 1;
    }
}

