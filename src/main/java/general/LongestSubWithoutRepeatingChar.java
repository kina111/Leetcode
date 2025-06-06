/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

import java.util.Arrays;

/*
Task: Given a string s, find the length of the longest substring without duplicate characters.
     (consists of English letters, digits, symbols and spaces)
Sol: Sliding Window, use a start and an end variable to easily visualize
Time: O(n), Space: O(1)
*/
public class LongestSubWithoutRepeatingChar {

    public LongestSubWithoutRepeatingChar() {
    }
    
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int[] cnt = new int[95];
        Arrays.fill(cnt, 0);
        int start = 0;
        for (int end = 0; end < s.length(); end++){
            int valueInCnt = s.charAt(end) - 32;
            cnt[valueInCnt]++;
            while (cnt[valueInCnt] > 1){
                cnt[s.charAt(start)-32]--;
                start++;
            }
            longest = Integer.max(longest, end-start+1);
        } 
        return longest;
    }
    
    public static void main(String[] args) {
        LongestSubWithoutRepeatingChar helper = new LongestSubWithoutRepeatingChar();
        String s = "pppp";
        System.out.println(helper.lengthOfLongestSubstring(s));
    }
}
