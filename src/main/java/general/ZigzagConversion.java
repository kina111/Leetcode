/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;
/*
Task: Convert a string like "PAYPALISHIRING" into zigzag form like below (with given num of rows)
    P   A   H   N
    A P L S I I G
    Y   I   R
Sol: Follow a fomulas and append characters row by row
Time: O(n) Space: O(n) for string result
*/
public class ZigzagConversion {

    public ZigzagConversion() {
    }
    
    public String convert(String s, int numRows) {
        int len = s.length();
        if (numRows == 1) return s;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= numRows-1 && i < len; i++){
            int down = 2 * (numRows-1-i);
            int up = 2 * i;
            if (down == 0) down = up;
            if (up == 0) up = down;
            boolean isDown = true;
            int currentIdx = i;
            while (currentIdx < len){
                result.append(s.charAt(currentIdx));
                if (isDown){
                    currentIdx += down;
                    isDown = false;
                }else{
                    currentIdx += up;
                    isDown = true;
                }
            }
        }
        return result.toString();
    }
    
    public static void main(String[] args) {
        ZigzagConversion helper = new ZigzagConversion();
        String s = "A";
        int numRows = 1;
        System.out.println(helper.convert(s, numRows));
    }
}
