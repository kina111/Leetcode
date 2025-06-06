/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binarySearchTree;

/*
Task: Check whether the given tree is a BST
Sol: Any problems related to BST, consider a solution using inOrderTraversal.
*/
public class ValidateBinarySearchTree {
    boolean result;
    long currentValue = (long) Integer.MIN_VALUE - 1;
    public boolean isValidBST(TreeNode root) {
        result = true;
        dfs(root);
        return result;
    }

    private void dfs(TreeNode node){
        if (node == null || !result) return;
        dfs(node.left);
        if (currentValue >= node.val) {
            result = false;
            return;
        }
        currentValue = node.val;
        dfs(node.right);
    }
}
