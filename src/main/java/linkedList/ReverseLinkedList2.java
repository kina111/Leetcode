/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedList;

/*
Task: Reverse a linkedList from left to right
Note: In linkedList problems, using a dummy node having .next = head can avoid null processing at head
--> much more simpler
Sử dụng kỹ thuật "cắt - nối con trỏ" để đảo ngược từng node một.
*/
public class ReverseLinkedList2 {

    public ReverseLinkedList2() {
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Di chuyển đến vị trí trước `left`
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode start = prev.next;  // Node bắt đầu đảo ngược
        ListNode then = start.next;  // Node tiếp theo của `start`

        // Đảo ngược các node từ left đến right
        for (int i = 0; i < right - left; i++) {
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }

        return dummy.next;
    }


    public static void main(String[] args) {
        ReverseLinkedList2 helper = new ReverseLinkedList2();
        int[] values = {1, 2, 3, 4, 5, 6};
        int start = 2, end = 4;
        ListNode head = new ListNode();
        head = head.createLinkedList(values);
        head.printLinkedList(helper.reverseBetween(head, start, end));
    }
}
