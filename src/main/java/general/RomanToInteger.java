/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

import java.util.HashMap;

/*
Task: Represent Roman number in interger form.
Sol: the best way is working from the back to front and using a map
(a simple but interesting problem that iterating from back is much simpler)
*/
public class RomanToInteger {
    public static int romanToInt(String s) {
        int result = 0;
        int len = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        //working from front to back
//        for (int i = 0; i < len-1; i++){
//            Character current = s.charAt(i);
//            if (current == 'V' || current == 'L' || current == 'D' || current == 'M'){
//                result += map.get(current);
//            }else{
//                if (current == 'I' && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X')){
//                    result -= map.get(current);
//                }else if (current == 'X' && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')){
//                    result -= map.get(current);
//                }else if (current == 'C' && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')){
//                    result -= map.get(current);
//                }else{
//                    result += map.get(current);
//                }
//            }
//        }
//        result += map.get(s.charAt(len-1));

    //working from back to front, much simpler
        result += map.get(s.charAt(len-1));
        for (int i = len-2; i >= 0; i--){
            if (map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                result -= map.get(s.charAt(i));
            }else{
                result += map.get(s.charAt(i));
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        String romanNumber = "MCMXCIV";
        System.out.println(romanToInt(romanNumber));
    }
}
