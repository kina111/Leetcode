/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
Task: Given an array of strings strs, group the anagrams together. 
Solution: 1. Using HashMap Time + Space: O(n*k)
           (encode each String like #10#0#1#2 (for aaaaaaaaaacdd) and use it as the key for hashMap)
*/
public class GroupAnagrams {

    public GroupAnagrams() {
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        String stringKey;
        int[] count = new int[26];//as lowercase only
        for (String s : strs) {
            //encode String to get the key
            Arrays.fill(count, 0);
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append('#').append(count[i]);
            }
            //get the key
            stringKey = sb.toString();
            //put into the map
            map.computeIfAbsent(stringKey, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams helper = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = helper.groupAnagrams(strs);
        for (List<String> ls : result) {
            System.out.println(ls.toString());
        }
    }
}
