/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author FPT
 */
public class IsomorphicStrings {

    public IsomorphicStrings() {
    }

    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> anhxaS = new HashMap<>();
        HashMap<Character, Character> anhxaT = new HashMap<>();
        if (s.length() != t.length()) return false;
        for (int i = 0; i < s.length(); i++){
            char tempS = s.charAt(i);
            char tempT = t.charAt(i);
            if (!anhxaS.containsKey(tempS)){
                anhxaS.put(tempS, tempT);
            }else if (anhxaS.get(tempS) != tempT){
                return false;
            }
            
            if (!anhxaT.containsKey(tempT)){
                anhxaT.put(tempT, tempS);
            }else if (anhxaT.get(tempT) != tempS){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        IsomorphicStrings helper = new IsomorphicStrings();
        String s ="badc" ; String t = "baba";
        System.out.println(helper.isIsomorphic(s, t));
    }
}
