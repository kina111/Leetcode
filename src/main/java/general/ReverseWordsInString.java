/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

/*
Task: Return a string of the words in reverse order concatenated by a single space
Sol: 1. Using built-in functions (trim, split) Space: O(n)
     2. Not using 
*/
public class ReverseWordsInString {

    public ReverseWordsInString() {
    }
    
    public String reverseWordsUsingBuiltInFunctions(String s) {
        String[] strgs = s.trim().split("[\\s]+");
        StringBuilder result = new StringBuilder();
        for (int i = strgs.length-1; i >= 1; i--){
            result.append(String.format("%s ", strgs[i]));
        }
        result.append(strgs[0]);
        return result.toString();
    }
    
    public String reverseWords(String s){
        //remove head-spaces and tail-spaces
        String copyS = s.trim();
        StringBuilder word = new StringBuilder();
        StringBuilder res = new StringBuilder();
        int idx = copyS.length()-1;
        while (idx >= 0){
            word = new StringBuilder();
            while (idx >= 0 && Character.isSpaceChar(copyS.charAt(idx))) idx--;
            while (idx >= 0 && Character.isLetter(copyS.charAt(idx))){
                word.append(copyS.charAt(idx));
            }
            res.append(word.reverse()).append(" ");
        }
        return res.deleteCharAt(res.capacity()-1).toString();
    }
    public static void main(String[] args) {
        ReverseWordsInString helper = new ReverseWordsInString();
        String input = "the sky    is blue";
        System.out.println(helper.reverseWords(input));
    }
}
