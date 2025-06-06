/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedList;

import java.util.ArrayList;
import java.util.List;

/*
Task: Remove the Nth node from the end
Sol: Two-Pointers(slow, fast) that the gap is n, so when fast hit end of list, slow will be the previous node of deleted node.
*/
public class RemoveNthFromEnd {
    //O(n) / O(n)
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<ListNode>();
        ListNode temp = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        nodes.add(dummy);
        while (temp != null){
            nodes.add(temp);
            temp = temp.next;
        }
        int idx = nodes.size() - n - 1;    
        ListNode start = nodes.get(idx);
        start.next = start.next.next;
        return dummy.next;
    }
    
    // O(n) / O(1)
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        for (int i = 1; i <= n; i++) fast = fast.next;
        while (fast.next != null){
            slow = slow.next; 
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
