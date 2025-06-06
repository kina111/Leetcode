/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binaryTreeGeneral;
import java.util.Queue;
import java.util.ArrayDeque;


/*
Task: Connect a perfect binary tree

*/
public class day38_PopulatingNextRightPointers {

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
    }

    //using bfs O(n) - O(n)
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        int cntNode = 0, height = 1, nofNode = (int) Math.pow(2, height) - 1;
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            cntNode++;
            if (cntNode == nofNode) {
                height++;
                nofNode = (int) Math.pow(2, height) - 1;
                curr.next = null;
            } else {
                curr.next = queue.peek();
            }
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
        return root;
    }
    
    //using dfs O(n) - O(logn) cho stack de quy
    public Node connect2(Node root){
        if (root == null) return null;
        dfsConnect(root, null);
        return root;
    }
    
    private void dfsConnect(Node root, Node next){
        if (root == null) return;
        root.next = next;
        dfsConnect(root.left, root.right);
        dfsConnect(root.right, root.next == null ? null : root.next.left);
    }
}
