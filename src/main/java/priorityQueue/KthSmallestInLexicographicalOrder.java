/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package priorityQueue;

/*
Task: Given two integers n and k, return the kth lexicographically smallest integer in the range [1, n].

Complex: O(logn*logn)-much faster than normal traveraling a trie
 */
public class KthSmallestInLexicographicalOrder {

    public int findKthNumber(int n, int k) {
        int cur = 1;
        k -= 1;
        while (k != 0) {
            int steps = calSteps(n, cur, cur + 1);
            if (steps <= k) {
                cur += 1;
                k -= steps;
            } else {
                cur *= 10;
                k -= 1;
            }
        }
        return cur;
    }

    public int calSteps(int n, long n1, long n2) {
        int steps = 0;
        while (n1 <= n) {
            steps += Math.min(n + 1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return steps;
    }
}
