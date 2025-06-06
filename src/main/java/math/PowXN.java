/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package math;

/**
 *
 * @author FPT
 */
public class PowXN {
    //Time: O(logN) / O(logN) for logN stack frame
    public double myPow(double x, int n) {
        if (n == -2147483648) return x * myPow(1.0/x, -n-1);
        if (n == 0) return 1;
        if (n == 1) return x; 
        if (n < 0) return myPow(1.0/x, -n);

        double a = myPow(x, n / 2);
        if (n % 2 == 1) return a * a * x;
        return a * a;
    }
    
    public double myPow2(double x, int n) {
        long mu = n;
        if (n < 0){
            x = 1/x; mu = -((long)n);
        }
        double pow = 1;
        while (mu != 0){
            if (mu % 2 == 1){
                pow *= x;
            }
            x *= x;
            mu /= 2;
        }
        return pow;
    }
}
