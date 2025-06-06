/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dynamicProgramming;

/*
Task: Simply return the number of ways from top-left to bottom-right in a matrix m*n.
 */
public class UniquePathI {

    public int uniquePaths(int m, int n) {
        int totalSteps = m + n - 2, downSteps = m - 1;
        long res = mCn(totalSteps, downSteps);
        if (res > Integer.MAX_VALUE) {
            throw new ArithmeticException("Result overflows int");
        }
        return (int) res;
    }

    public long mCn(int m, int n) {
        if (n < 0 || n > m) {
            return 0;
        }
        if (n == 0 || n == m) {
            return 1;
        }

        long result = 1;
        n = Math.min(n, m - n);

        for (int i = 1; i <= n; i++) {
            result = result * (m - i + 1) / i;
        }

        return result;
    }
}
