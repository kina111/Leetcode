/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedList;

/*
Task:  given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.
*/
public class AddTwoNumbers {

    public class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode res = new ListNode();
            ListNode tempRes = res;
            ListNode tempL1 = l1, tempL2 = l2;
            int bonus = 0;
            while (tempL1 != null && tempL2 != null){
                int num = tempL1.val + tempL2.val + bonus;
                bonus = num / 10;
                tempRes.next = new ListNode(num % 10);
                tempRes = tempRes.next;
                tempL1 = tempL1.next; tempL2 = tempL2.next;
            }
            while (tempL1 != null){
                int num = tempL1.val + bonus;
                bonus = num / 10;
                tempRes.next = new ListNode(num % 10);
                tempRes = tempRes.next;
                tempL1 = tempL1.next;
            }
            while (tempL2 != null){
                int num = tempL2.val + bonus;
                bonus = num / 10;
                tempRes.next = new ListNode(num % 10);
                tempRes = tempRes.next;
                tempL2 = tempL2.next;
            }
            if (bonus == 1) tempRes.next = new ListNode(1);
            return res.next;
        }
    }
    
    public static void main(String[] args) {
        
    }
}
