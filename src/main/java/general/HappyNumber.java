/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

/**
 *
 * @author FPT
 */
public class HappyNumber {

    public HappyNumber() {
    }

    public int happify(int num) {
        int ans = 0;
        while (num > 0) {
            int remainder = num % 10;
            ans += remainder * remainder;
            num /= 10;
        }
        return ans;
    }

    public boolean isHappy(int n) {
        while (n >= 10) {
            n = happify(n);
        }
        return (n == 1 || n == 7);
    }

    public static void main(String[] args) {
        int n = 2;
        HappyNumber helper = new HappyNumber();
        System.out.println(helper.isHappy(n));
    }
}
