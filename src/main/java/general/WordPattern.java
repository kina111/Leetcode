/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;
import java.util.Arrays;
import java.util.HashMap;

/*
Task: Given a pattern and a string s, find if s follows the same pattern.
    Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s. Specifically:
        Each letter in pattern maps to exactly one unique word in s.
        Each unique word in s maps to exactly one letter in pattern.
        No two letters map to the same word, and no two words map to the same letter.
Solution: using two hashMap to map word to char and char to word.
    */
public class WordPattern {

    public WordPattern() {
    }
    
    public boolean isIsomorphic(String pattern, String s) {
        String[] words = s.split(" ");
        HashMap<Character, String> mapCharToWord = new HashMap<>();
        HashMap<String, Character> mapWordToChar = new HashMap<>();
        if (pattern.length() != words.length) return false;
        char charTemp; String wordTemp;
        for (int i = 0; i < pattern.length(); i++){
            charTemp = pattern.charAt(i);
            wordTemp = words[i];
            if (!mapCharToWord.containsKey(charTemp)){
                mapCharToWord.put(charTemp, wordTemp);
            }else if (!mapCharToWord.get(charTemp).equals(wordTemp)){
                return false;
            }
            if (!mapWordToChar.containsKey(wordTemp)){
                mapWordToChar.put(wordTemp, charTemp);
            }else if (mapWordToChar.get(wordTemp) != charTemp){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        WordPattern helper = new WordPattern();
        String pattern ="abba" ; String s = "dog cat cat dog";
//        System.out.println(Arrays.toString(s.split(" ")));
        System.out.println(helper.isIsomorphic(pattern, s));
    }
}
