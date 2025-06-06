/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binarySearchTree;

/*
Task: Given the root of a binary search tree, and an integer k, 
Return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

Sol: Using dfs + inOrderTraversal
*/
public class KthSmallestElementinaBST {
    int result;
    int cnt = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return result;
    }

    private void dfs(TreeNode node, int k){
        if (node == null || cnt > k) return;
        dfs(node.left, k);
        cnt++;
        if (cnt == k) result = node.val;
        dfs(node.right, k);
    }
}
