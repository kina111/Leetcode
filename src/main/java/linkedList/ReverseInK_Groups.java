/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedList;

import java.util.HashSet;

/**
 *
 * @author FPT
 */
public class ReverseInK_Groups {

    public ReverseInK_Groups() {
    }
    
    public ListNode reverseNextKNode(ListNode head, int k){
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = head, curr = prev.next;
        for (int i = 1; i <= k-1; i++){
            prev.next = curr.next;
            curr.next = dummy.next;
            dummy.next = curr;
            curr = prev.next;
        }
        return dummy.next;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        int nofNodesRemain = 0; ListNode temp = head;
        while (temp != null){
            nofNodesRemain++; temp = temp.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, curr = prev.next;
        while (nofNodesRemain >= k){
            ListNode saveForPrev = curr;
            prev.next = reverseNextKNode(curr, k);
            prev = saveForPrev; 
            curr = prev.next;
            nofNodesRemain -= k;
        }
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ReverseInK_Groups helper = new ReverseInK_Groups();
        int[] values = {1, 2, 3, 4, 5, 6};
        int k = 4;
        ListNode head = new ListNode();
        head = head.createLinkedList(values);
        head.printLinkedList(helper.reverseKGroup(head, k));
    }
}
