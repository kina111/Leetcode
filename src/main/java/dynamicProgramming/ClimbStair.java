/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/*
Task: You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top

*/
public class ClimbStair {
    static List<Integer> res = new ArrayList<>();
    static{
        res.add(0); res.add(1); res.add(2);
    }  
    public int climbStairs(int n) {
        if (n < res.size()) return res.get(n);
        for (int i = res.size(); i <= n; i++){
            res.add(res.get(i-1) + res.get(i-2));
        }
        return res.get(n);
    }
}   
