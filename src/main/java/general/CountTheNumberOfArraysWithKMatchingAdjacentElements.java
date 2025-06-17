/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package general;

/**
 * Task: You are given three integers n, m, k. A good array arr of size n is defined as follows:
 * Each element in arr is in the inclusive range [1, m].
 * Exactly k indices i (where 1 <= i < n) satisfy the condition arr[i - 1] == arr[i].
 * Return the number of good arrays that can be formed.
 * Since the answer may be very large, return it modulo 109 + 7.
   

* tips: + Fermat's theorem: a^(p-1) mod p = 1 ---> a^(p-2) mod p = a^(-1)
*       + calculate Pow(a, b) with O(logb).
* 
* Sol: Have m options for arr[0]. For the n-1 indices left, choose k position that arr[i] = arr[i-1].
* Then for each indices in n-1-k positions left, have m-1 options.
* --> Result = m * C(k, n-1) * (m-1)^(n-1-k).
* 


 */
public class CountTheNumberOfArraysWithKMatchingAdjacentElements {

    static final int MOD = 1_000_000_007;

    public class ToHopModNganGon {

        static final int MAX = 100000;
        static long[] fact = new long[MAX + 1];
        static long[] invFact = new long[MAX + 1];//use Fermat's theorem to set up

        static {
            fact[0] = invFact[0] = 1;
            for (int i = 1; i <= MAX; i++) {
                fact[i] = fact[i - 1] * i % MOD;
            }
            invFact[MAX] = pow(fact[MAX], MOD - 2);
            for (int i = MAX - 1; i >= 1; i--) {
                invFact[i] = invFact[i + 1] * (i + 1) % MOD;
            }
        }
        
        //calculate pow(a,b) with O(logb)
        static long pow(long a, long b) {
            long res = 1;
            while (b > 0) {
                if ((b & 1) == 1) {
                    res = res * a % MOD;
                }
                a = a * a % MOD;
                b >>= 1; //divide b by 2
            }
            return res;
        }

        static long C(int m, int n) {
            if (n < 0 || n > m) {
                return 0;
            }
            return fact[m] * invFact[n] % MOD * invFact[m - n] % MOD;
        }
    }

    public int countGoodArrays(int n, int m, int k) {
        long temp = ToHopModNganGon.C(n - 1, k);
        long res = ((temp * m) % MOD) * ToHopModNganGon.pow(m - 1, n - 1 - k) % MOD;
        return (int) res;
    }
}
