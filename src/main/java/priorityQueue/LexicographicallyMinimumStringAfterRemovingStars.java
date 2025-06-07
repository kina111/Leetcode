/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package priorityQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
Task: Given a string including only lowercase alphabets and character '*'
While there is a '*', do the following operation:
    Delete the leftmost '*' and the smallest non-'*' character to its left. 
    If there are several smallest characters, you can delete any of them. 
Return the lexicographically smallest resulting string after removing all '*' characters.

Sol: Using priorityQueue to find the smallest non-'*' to the left and mark it index.
As there are only 26 alphabets,
--> Sol2: Using buckets
 */
public class LexicographicallyMinimumStringAfterRemovingStars {

    //O(n*logn) O(n)
    class Solution1 {

        class Alpha {

            char c;
            int idx;

            Alpha(char c, int idx) {
                this.c = c;
                this.idx = idx;
            }
        }

        public String clearStars(String s) {
            int n = s.length();
            boolean[] used = new boolean[n];

            PriorityQueue<Alpha> pq = new PriorityQueue<>((a, b) -> {
                if (a.c != b.c) {
                    return Character.compare(a.c, b.c);
                }
                return b.idx - a.idx; // prioritize greater index if two chars are equal
            });

            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (ch == '*') {
                    if (!pq.isEmpty()) {
                        Alpha removed = pq.poll();
                        used[removed.idx] = true; // mark idx of deleted char
                    }
                    used[i] = true; // mark idx of '*'
                } else {
                    pq.offer(new Alpha(ch, i));
                }
            }

            // get result
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (!used[i]) {
                    result.append(s.charAt(i));
                }
            }

            return result.toString();
        }
    }

    //O(n * 26) O(n)
    class Solution2 {

        public String clearStars(String s) {
            StringBuilder sb = new StringBuilder(s);
            List<Integer>[] buckets = new List[26];
            for (int i = 0; i < 26; ++i) {
                buckets[i] = new ArrayList<>();
            }

            for (int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                if (c == '*') {
                    sb.setCharAt(i, ' ');
                    for (int j = 0; j < 26; ++j) {
                        if (!buckets[j].isEmpty()) {
                            int idx = buckets[j].remove(buckets[j].size() - 1);
                            sb.setCharAt(idx, ' ');
                            break;
                        }
                    }
                } else {
                    buckets[c - 'a'].add(i);
                }
            }

            return sb.toString().replaceAll(" ", "");
        }
    }
}
