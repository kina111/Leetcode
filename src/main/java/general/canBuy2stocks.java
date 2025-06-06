/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

/*
Task: On each day, you have to sell or buy stock, and you can only hold one stock
Solution: Greedy, just see on a stockLine on Web
Time: O(n) Space: O(1)
Note: I spent more than hour just because I didn't read task carefully (so awful) :))
*/
public class canBuy2stocks {
    public static Double maxProfit(int[] prices){
        double profit = 0;
        for (int i = 1; i < prices.length; i++){
            if (prices[i] > prices[i-1]){
                profit += (prices[i] - prices[i-1]);
            }
        }
        return profit;
    }
    
    public static void main(String[] args) {
        int[] prices = {9, 1, 4, 7, 3, 2, 10, 5, 8};
        System.out.println(maxProfit(prices));
    }
}
