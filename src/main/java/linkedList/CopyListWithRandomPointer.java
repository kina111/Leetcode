/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedList;

import java.util.HashMap;

/*
Task: create a deep copy of a linkedList (that has a next pointer and a random pointer pointing to a Node in the list)
Sol: 1. Using a HashMap, each time create a Node in the new List, we create a oldNode--> newNode mapping.
        O(n)/O(n)
     2. Interleave new nodes within the original list and then split them for result
        O(n)/O(n)
 */
public class CopyListWithRandomPointer {

    class Node {

        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {

        public Node copyRandomList1(Node head) {
            if (head == null) {
                return null;
            }
            HashMap<Node, Node> map = new HashMap<>();
            Node tempHead = head;//not to change the input head
            Node tempRes = new Node(head.val);
            Node res = tempRes;
            map.put(tempHead, tempRes);

            while (tempHead != null) {
                //update current tempRes.next
                if (tempHead.next == null) {
                    tempRes.next = null;
                } else if (map.containsKey(tempHead.next)) {
                    tempRes.next = map.get(tempHead.next);
                } else {
                    tempRes.next = new Node(tempHead.next.val);
                    map.put(tempHead.next, tempRes.next);
                }

                //update curernt tempRes.random
                if (tempHead.random == null) {
                    tempRes.random = null;
                } else if (map.containsKey(tempHead.random)) {
                    tempRes.random = map.get(tempHead.random);
                } else {
                    tempRes.random = new Node(tempHead.random.val);
                    map.put(tempHead.random, tempRes.random);
                }
                tempHead = tempHead.next;
                tempRes = tempRes.next;
            }
            return res;
        }

        public Node copyRandomList2(Node head) {
            // Step 1: Insert copied nodes next to original nodes
            Node temp = head;
            while (temp != null) {
                Node copy = new Node(temp.val);
                copy.next = temp.next;
                temp.next = copy;
                temp = copy.next;
            }

            // Step 2: Assign random pointers for copied nodes
            temp = head;
            while (temp != null) {
                if (temp.random != null) {
                    temp.next.random = temp.random.next;
                }
                temp = temp.next.next;
            }

            // Step 3: Separate new list from the original list
            Node dummy = new Node(0);
            Node newHead = dummy, curr = head;
            while (curr != null) {
                newHead.next = curr.next;
                curr.next = curr.next.next;
                curr = curr.next;
                newHead = newHead.next;
            }
            return dummy.next;
        }
    }
}
