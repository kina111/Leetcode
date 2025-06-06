/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedList;

import java.util.HashMap;

/*
Task: Return true if a linkedList has a cycle and false otherwise..
Sol: 1. As there are only 10^4 node, so using a variable cnt to count the number of node passed.
     Then if cnt >= 10^4, it has a cycle.

     2. Using Tortoise and Hare algorithm (much efficient)
     (Floyd's cycle detection algorithm)
*/
public class LinkedListCycle {

    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode temp = head;
        int cnt = 0;
        while (true) {
            if (temp.next == null) {
                return false;
            }
            temp = temp.next;
            cnt++;
            if (cnt >= 10000) {
                break;
            }
        }
        return true;
    }

   public boolean hasCycle2(ListNode head){
       if (head == null) return false;
       ListNode tortoise = head;
       ListNode hare = head;
       while (true){
           if (hare.next == null || hare.next.next == null) return false;
           tortoise = tortoise.next;
           hare = hare.next.next;
           if (tortoise == hare) break;
       }
       return true;
   }
}
