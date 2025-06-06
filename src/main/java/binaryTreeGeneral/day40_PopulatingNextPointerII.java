/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binaryTreeGeneral;

import java.util.LinkedList;
import java.util.Queue;

/*

    Figure A: Original Binary Tree Structure

           1
         /   \
        2     3
       / \     \
      4   5     7

    Figure B: Binary Tree with Next Right Pointers Connected

           1 -> NULL
         /   \
        2  -> 3 -> NULL
       / \     \
      4-> 5 -> 7 -> NULL

    Each node is connected to its immediate right neighbor on the same level.
    If there is no neighbor, the node points to NULL.
 */
public class day40_PopulatingNextPointerII {

    class Node {

        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    //O(n) / O(n)
    //for each level, put all the node into a queue at first, then connect them
    public Node connect1(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 1; i <= size; i++) {
                Node curr = queue.poll();
                if (i == size) {
                    curr.next = null;
                } else {
                    curr.next = queue.peek();
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
        }
        return root;
    }

    //O(n) / Constant
    //consider each level is a linkedList that we create one by one from top down
    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        Node head = root;
        while (head != null) {
            Node dummy = new Node(0);
            Node temp = dummy;
            //connect in each level
            while (head != null) {
                if (head.left != null) {
                    temp.next = head.left;
                    temp = temp.next;
                }
                if (head.right != null) {
                    temp.next = head.right;
                    temp = temp.next;
                }
                head = head.next;
            }
            //go on next level
            head = dummy.next;
        }
        return root;
    }
}
