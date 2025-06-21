/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

import java.util.ArrayList;
import java.util.List;

/**
 * Task: You are given a string word and an integer k.
 *  We consider word to be k-special if |freq(word[i]) - freq(word[j])| <= k for all indices i and j in the string.
 * Here, freq(x) denotes the frequency of the character x in word, and |y| denotes the absolute value of y.
 * Return the minimum number of characters you need to delete to make word k-special.
 * 
 * Note: When process with count character alphabet, brute-force is also a efficient method**.
 */
public class MinimumDeletetionsToMakeStringKSpecial {
    public int minimumDeletions(String word, int k) {
        int res = Integer.MAX_VALUE;
        
        //count the freq of each char
        int[] cnt = new int[26];
        for (char c : word.toCharArray()){
            cnt[c-97]++;
        }
        
        //put these freq to a list
        List<Integer> exist = new ArrayList<>();
        for (int i = 0; i < 26; i++){
            if (cnt[i] > 0){
                exist.add(cnt[i]);
            }
        }
        
        //for each value of freq, we cal the change to fit the range [freq, freq + k]
        int len = exist.size();
        for (int i = 0; i < len; i++){
            int min = exist.get(i), max = exist.get(i) + k, temp = 0;
            for (int j = 0; j < len; j++){
                if (exist.get(j) < min){
                    temp += exist.get(j);
                }else if (exist.get(j) > max){
                    temp += (exist.get(j) - max);
                }
            }
            res = Math.min(temp, res);
        }

        return res;
    }
}
