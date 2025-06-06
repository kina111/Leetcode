/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backtrack;

import java.util.ArrayList;
import java.util.List;

/*
Task: Give n, k. List all combinations with k elements in range [1, n]
eg: n = 4, k = 2  ---> 1 2, 1 3, 1 4, 2 3, 2 4, 3 4
*/
public class Combinations {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        int start = 1, end = n, nofLeft = k;
        List<Integer> curr = new ArrayList<>();
        backtrack(start, end, nofLeft, curr);
        return result;
    }
    public void backtrack(int start, int end, int nofLeft, List<Integer> curr){     
        if (nofLeft == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }
        if (start > end) return;
        for (int i = start; i <= end; i++){
            curr.add(i); nofLeft--;
            backtrack(i+1, end, nofLeft, curr);
            curr.remove(curr.size()-1); nofLeft++;
        }
    }
}
