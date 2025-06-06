/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

/*
Task: Convert a Integer into RomanForm
Sol: First thought is using HashMap, then String is another good choice as it has limited options.
---> The answer is quite beautiful.
Time+Space: ~O(1)
*/
public class IntegerToRoman {
    public static String intToRoman(int num) {
        String[] m = {"", "M", "MM", "MMM"};
        String[] c = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] x = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] i = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return m[num/1000] + c[(num%1000)/100] + x[(num%1000)%100 / 10] + i[num%1000%100%10];
    }
    
    public static void main(String[] args) {
        int num = 1998;
        System.out.println(intToRoman(num));
    }
}
