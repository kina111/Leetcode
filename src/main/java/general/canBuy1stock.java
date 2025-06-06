/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

/*
Task: You are given an array prices where prices[i] is the price of a given stock on the ith day. Buy and sell in the future
Return the maximum profit. If you cannot achieve any profit, return 0.
Sol: Greedy
Time: O(n), Space: O(1)
*/
public class canBuy1stock {
    public static int maxProfit(int[] prices) {
        int minPrice = prices[0], maxPrice = prices[0], profit = 0;
        //there are two case for each day
        for (int i = 0; i < prices.length; i++){
            //case1: Better to sell 
            if (prices[i] > maxPrice){
                profit = Integer.max(profit, prices[i] - minPrice);
                maxPrice = prices[i];
            //case2: Better to buy
            }else if (prices[i] < minPrice){
                minPrice = prices[i];
                maxPrice = prices[i];
            }
        }
        return profit;
        
    }
    public static void main(String[] args) {
        int[] prices = {9,3,4,7,2,1,6,5,10};
        System.out.println(maxProfit(prices));
    }
}
