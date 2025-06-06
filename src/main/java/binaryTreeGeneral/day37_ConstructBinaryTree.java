/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binaryTreeGeneral;

import java.util.HashMap;

/*
Task: Constructing tree based on int[] preorder and inorder
Note: inorder will give information about how many nodes in each site of a TreeNode.
 */
public class day37_ConstructBinaryTree {

    class Solution {

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            TreeNode result = buildTree(0, 0, inorder.length - 1, preorder, inorder, map);
            return result;
        }

        public TreeNode buildTree(int preIdx, int inStart, int inEnd, int[] preorder, int[] inorder, HashMap<Integer, Integer> map) {
            //base case
            if (preIdx >= preorder.length || inStart > inEnd) {
                return null;
            }

            TreeNode root = new TreeNode(preorder[preIdx]);
            int inIdx = map.get(preorder[preIdx]);
            root.left = buildTree(preIdx + 1, inStart, inIdx - 1, preorder, inorder, map);
            root.right = buildTree(preIdx + inIdx - inStart + 1, inIdx + 1, inEnd, preorder, inorder, map);
            return root;
        }
    }
}
