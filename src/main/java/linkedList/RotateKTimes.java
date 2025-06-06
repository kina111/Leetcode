/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedList;

/*
Task: Rotate a linkedList k times 
Sol: 1. Similar to rotate an array [] as reverse whole --> reverse first part --> reverse second part
     2. connect last->first to circular linkedList, then cut  at approciate point
     (much cleaner and simpler)
*/
public class RotateKTimes {
    //sol1
    public ListNode reverse(ListNode head){
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
    public ListNode rotateRight1(ListNode head, int k) {
        int nofNodes = 0;ListNode temp = head;
        while (temp != null){
            nofNodes++; temp = temp.next;
        }
        if (nofNodes == 0 || nofNodes == 1 || k % nofNodes == 0) return head;

        //reverse whole list
        ListNode headOfReverse = reverse(head);
        
        //reverse first part
        ListNode prev = headOfReverse, curr = prev.next;
        for (int i = 1; i <= k % nofNodes - 1; i++){
            prev.next = curr.next;
            curr.next = headOfReverse;
            headOfReverse = curr;
            curr = prev.next;
        }
        //reverse second part
        prev.next = reverse(curr);
        return headOfReverse;
    }
    
    //sol2
    public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null || k == 0) return head; // Trường hợp cơ bản

    // Đếm số node trong danh sách
    int nofNodes = 1; // Bắt đầu từ 1 vì ta sẽ duyệt từ head
    ListNode temp = head;
    while (temp.next != null) {
        nofNodes++;
        temp = temp.next;
    }
    
    // Kết nối node cuối với node đầu để tạo danh sách vòng
    temp.next = head;

    // Tìm vị trí node mới sẽ trở thành head
    k = k % nofNodes;
    int stepsToNewHead = nofNodes - k;
    temp = head;

    for (int i = 1; i < stepsToNewHead; i++) {
        temp = temp.next;
    }

    // Đặt node mới làm head và ngắt liên kết vòng
    head = temp.next;
    temp.next = null;

    return head;
}

}
