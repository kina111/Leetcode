/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

/**
Task: Check if a string is palindrome
Note: Character class
 */
public class IsPalindrome {
    public static boolean isPalindrome(String s) {
        String copyS = s.toLowerCase();
        int left = 0, right = copyS.length()-1;
        while (left < right){
            while (left < right && !Character.isLetterOrDigit(copyS.charAt(left))){
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(copyS.charAt(right))){
                right--;
            }
            //if (left >= right) return true;
            if (copyS.charAt(left) != copyS.charAt(right)){
                return false;
            }
            left++; right--;
        }
        return true;
    }
    
    public static void main(String[] args) {
        String input = " ";
        System.out.println(isPalindrome(input));
    }
}
