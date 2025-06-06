/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dynamicProgramming;

/*
Task: Given a string s, return the longest palindromic substring in s.

*/
public class LongestPalindromeSubstring {
    //using dp with time && space is O(n^2)
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 1) return s;

        boolean[][] check = new boolean[len][len];
        for (int i = 0; i < len; i++) check[i][i] = true;
        int left = 0, right = 0, max = 0;
        
        //iterate for all (start, end) pairs
        for (int end = 1; end < len; end++){
            for (int start = 0; start < end; start++){
                if (end-start == 1){
                    check[start][end] = (s.charAt(start) == s.charAt(end));
                }else{
                    check[start][end] = (check[start+1][end-1] && s.charAt(start) == s.charAt(end));
                }
                if (check[start][end] && (end-start+1 > max)){
                    max = end-start+1;
                    left = start; right = end;
                }
            }
        }
        return s.substring(left, right+1);
    }
}
