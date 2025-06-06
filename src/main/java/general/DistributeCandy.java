/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;
/*
Task: There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
      You are giving candies to these children subjected to the following requirements:
            Each child must have at least one candy.
            Children with a higher rating get more candies than their neighbors.
      Return the minimum number of candies you need to have to distribute the candies to the children.
Sol: Maybe Greedy from both sides of array
Time: O(n) Space: O(1)
Note: Take examples to visualize, sometimes can figure out something
*/
public class DistributeCandy {
    public static int candy(int[] ratings) {
        int len = ratings.length;
        int[] distributeFromLeft = new int[len];
        int[] distributeFromRight = new int[len];
        distributeFromLeft[0] = 1;
        for (int i = 1; i < len; i++){
            distributeFromLeft[i] = (ratings[i] > ratings[i-1] ? distributeFromLeft[i-1]+1 : 1);
        }
        distributeFromRight[len-1] = 1;
        for (int i = len-2; i >= 0; i--){
            distributeFromRight[i] = (ratings[i] > ratings[i+1] ? distributeFromRight[i+1]+1 : 1);
        }
        int[] result = new int[len];
        int totalCandy = 0;
        for (int i = 0; i < len; i++){
            result[i] = Integer.max(distributeFromLeft[i], distributeFromRight[i]);
            totalCandy += result[i];
        }
        return totalCandy;
    }
    
    public static void main(String[] args) {
        int[] ratings = {1,2,2};
        System.out.println(candy(ratings));
    }
}
