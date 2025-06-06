/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binaryTreeBFS;

import java.util.LinkedList;
import java.util.Queue;

/*
* Given a binary tree, find its minimum depth.
* The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
* Note: A leaf is a node with no children.

* Sol: Prefer bfs to dfs to find shortest path.
*/
public class MinimumDepth {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int level = 0;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()){
            level++;
            int size = nodes.size();
            for (int i = 1; i <= size; i++){
                TreeNode current = nodes.poll();
                if (current.left == null && current.right == null) return level;
                if (current.left != null) nodes.offer(current.left);
                if (current.right != null) nodes.offer(current.right);
            }
        }
        return -1; // never reach this line.
    }
}
