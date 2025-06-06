/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binarySearchTree;

/*
Task: iven the root of a Binary Search Tree (BST), 
Return the minimum absolute difference between the values of any two different nodes in the tree.

Sol: Using dfs + inOrder-Traversal, as compute each pair of adjacent nodes
*/
public class MinimumAbsoluteDifferenceinBST {
    int minDiffer = Integer.MAX_VALUE;
    int currentVal = -100000;
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return minDiffer;
    }

    private void dfs(TreeNode node){
        if (node == null) return;
        dfs(node.left);
        minDiffer = Integer.min(minDiffer, Math.abs(node.val - currentVal));
        currentVal = node.val;
        dfs(node.right);
    }
}
