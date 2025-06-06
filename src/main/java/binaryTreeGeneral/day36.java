/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binaryTreeGeneral;

import java.util.HashMap;

/*
1. maximum depth of BT
2. Same Tree
3. Invert BT
4. Symmetric Tree
5. Path Sum

 */
public class day36 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode result = buildTree(postorder.length-1, 0, inorder.length-1, inorder, postorder, map);
        return result;
    }
    
    public TreeNode buildTree(int postIdx, int inStart, int inEnd, int[] inorder, int[] postorder, HashMap<Integer, Integer> map){
        if (inStart > inEnd || postIdx < 0) return null;
        TreeNode root = new TreeNode(postorder[postIdx]);
        int inIdx = map.get(postorder[postIdx]);
        root.left = buildTree(postIdx - (inEnd - inIdx + 1), inStart, inIdx-1, inorder, postorder, map);
        root.right = buildTree(postIdx - 1, inIdx+1, inEnd, inorder, postorder, map);
        return root;
    }
}
