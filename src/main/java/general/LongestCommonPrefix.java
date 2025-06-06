/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

/*
Task: Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".
Sol: 1. Check each character Time: O(n^2) Space: O(1)
     2. Trie????
*/
public class LongestCommonPrefix {

    public LongestCommonPrefix() {
    }
    
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        int shortestLength = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++){
            shortestLength = Integer.min(shortestLength, strs[i].length());
        }
        int countLongestPrefix = 0;
        boolean check;
        while (countLongestPrefix < shortestLength){
            check = true;
            for (int i = 0; i < len-1; i++){
                if (strs[i].charAt(countLongestPrefix) != strs[i+1].charAt(countLongestPrefix)){
                    check = false;
                    break;
                }
            }
            if (check) countLongestPrefix++;
            else break;
        }
        return strs[0].substring(0, countLongestPrefix);
    }
    
    public static void main(String[] args) {
        LongestCommonPrefix helper = new LongestCommonPrefix();
        String[] input = {"dog","racecar","car"};
        System.out.println(helper.longestCommonPrefix(input));
    }
}
