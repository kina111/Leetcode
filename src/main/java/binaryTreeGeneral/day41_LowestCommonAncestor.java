/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binaryTreeGeneral;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
Task: Find the lower common ancestor in a BT
*/
public class day41_LowestCommonAncestor {
    //Sol1: Consider given tree as a fullTree and Convert the whole tree to an Array O(n)/O(n)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(null);
        int idxP = -1, idxQ = -1;
        while (!queue.isEmpty()){
            int size = queue.size();
            boolean isFullNull = true;
            for (int i = 1; i <= size; i++){
                TreeNode temp = queue.poll();
                nodes.add(temp);
                if (temp != null){
                    isFullNull = false;
                    if (temp.val == p.val) idxP = nodes.size()-1;
                    if (temp.val == q.val) idxQ = nodes.size()-1;
                    queue.offer(temp.left);
                    queue.offer(temp.right);
                }else{
                    queue.offer(null);
                    queue.offer(null);
                }               
            }
            if (isFullNull) break;
        }
        while (idxP != idxQ){
            if (idxP < idxQ){
                idxQ = (idxQ % 2 == 0 ? (idxQ / 2) : (idxQ-1)/2);
            }else{
                idxP = (idxP % 2 == 0 ? (idxP / 2) : (idxP-1)/2);
            }
        }
        return nodes.get(idxP);
    }
    
    //Sol2: DFS O(n) / O(1) if not counting recursive stack frames
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
}
