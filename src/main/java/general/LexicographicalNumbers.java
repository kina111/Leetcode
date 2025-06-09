/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

import java.util.ArrayList;
import java.util.List;

/*
Task: Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.
You must write an algorithm that runs in O(n) time and uses O(1) extra space. 
eg: Input: n = 13
    Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]
*/
public class LexicographicalNumbers {
    //sol1: using dfs
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= 9; i++){
            dfs(i, n, res);
        }    

        return res;
    }
    
    public void dfs(int cur, int n, List<Integer> res){
        if (cur > n) return;
        res.add(cur);
        for (int i = 0; i <= 9; i++){
            dfs(cur*10 + i, n, res);
        }
    }
}
