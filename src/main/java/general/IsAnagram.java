/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

import java.util.HashMap;

/*
Task: Check if two string is anagram (with Unicode char)
Sol: Using HashMap to map Character -> nofChar
*/
public class IsAnagram {

    public IsAnagram() {
    }
    
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> freMap = new HashMap<>();
        for (char c : s.toCharArray()){
            freMap.put(c, freMap.getOrDefault(c, 0)+1);
        }
        for (char c : t.toCharArray()){
            if (!freMap.containsKey(c)) return false;
            freMap.put(c, freMap.get(c)-1);
            if (freMap.get(c) < 0) return false;
        }
        return true;
    }
    
    public boolean isAnagram2(String s, String t){
        if (s.length() != t.length()) return false;
        int[] cnt = new int[26];
        char temp;
        for (int i = 0; i < s.length(); i++){
            temp = s.charAt(i);
            cnt[temp-'a']++;
        }
        for (int i = 0; i < t.length(); i++){
            temp = t.charAt(i);
            cnt[temp-'a']--;
            if (cnt[temp-'a'] < 0) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        IsAnagram helper = new IsAnagram();
        String s = "tôi yêu"; String t = "yêu tôi";
        System.out.println(helper.isAnagram(s, t));
    }
}
