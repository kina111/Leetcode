/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedList;

/*
Task: Remove duplicates for a linkedList
 */
public class RemoveDuplicates {

    //remove duplicate values (eg. {1,1,1,2,3,3,4,5} --> {1,2,3,4,5}
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
    
    //keep only distinct values (eg. {1,1,1,2,3,3,4,5} --> {2,4,5}
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, start = head, curr = head;
        while (curr != null){
            int cnt = 0;//count number of node with the same value, count itself too.
            while (curr != null && curr.val == start.val){
                cnt++; curr = curr.next;
            }
            if (cnt == 1) {
                prev.next = start; prev = start;
            }
            start = curr;
        }
        prev.next = null;
        return dummy.next;
    }
    
    public static void main(String[] args) {
        RemoveDuplicates helper = new RemoveDuplicates();
        ListNode head = new ListNode();
        int[] values = {1, 1, 1, 2, 3, 4, 4, 5, 5};
        head = head.createLinkedList(values);
        head.printLinkedList(helper.deleteDuplicates(head));
    }
}
