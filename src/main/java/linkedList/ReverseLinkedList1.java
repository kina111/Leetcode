/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedList;

/*
Task: Reverse a linked List
Idea: "Cắt-nối" từng node lên đầu + sử dụng dummy node (tránh edge cases)
*/
public class ReverseLinkedList1 {

    public ReverseLinkedList1() {
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = head, curr = prev.next;
        while (curr != null){
            prev.next = curr.next;
            curr.next = dummy.next;
            dummy.next = curr;
            
            curr =prev.next;
        }
        return dummy.next;
    }
    
    //not need dummy 
    public ListNode reverseList2(ListNode head, int k) {
        if (head == null) return null;
        ListNode headOfReverse = head;
        ListNode prev = head, curr = headOfReverse.next;
        while (curr != null){
            prev.next = curr.next;
            curr.next = headOfReverse;
            headOfReverse = curr;
            curr = prev.next;
        }
        return headOfReverse;
    }
    
    public static void main(String[] args) {
        ReverseLinkedList1 helper = new ReverseLinkedList1();
        int[] values = {1, 2, 3, 4, 5, 6};
        ListNode head = new ListNode();
        head = head.createLinkedList(values);
        head.printLinkedList(helper.reverseList(head));
    }
}
