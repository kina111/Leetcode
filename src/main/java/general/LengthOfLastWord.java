/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

/*
Task: Count the lenth of last word in a string
Sol: loop from the back
Time: O(n) Space: o(1)
*/
public class LengthOfLastWord {

    public LengthOfLastWord() {
    }
    
    public int lengthOfLastWord(String s) {
        int idx = s.length()-1;
        while (Character.isSpaceChar(s.charAt(idx))) idx--;
        int count = 0;
        while (idx >= 0 && Character.isLetter(s.charAt(idx))){
            count++;
            idx--;
        }
        return count;
    }
    public static void main(String[] args) {
        LengthOfLastWord s = new LengthOfLastWord();
        System.out.println(s.lengthOfLastWord("   fly me   to   the moon  "));
    }
}
