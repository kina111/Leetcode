/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backtrack;

import java.util.ArrayList;
import java.util.List;

/*
Task: Given the root of a binary tree, return all root-to-leaf paths in any order.
      A leaf is a node with no children.
eg: Input: root = [1,2,3,null,5]
    Output: ["1->2->5","1->3"]
 */
public class BinaryTreePaths {

    // Definition for a binary tree node.
    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
//    List<String> res = new ArrayList<>();
//
//    public List<String> binaryTreePaths(TreeNode root) {
//        findPathRec(root, new StringBuilder(""));
//        return res;
//    }
//
//    //solution 1: backtrack + dfs
//    private void findPathRec(TreeNode root, StringBuilder current) {
//        //if root if a leaf
//        if (root.left == null && root.right == null) {
//            current.append(root.val);
//            res.add(current.toString());
//            current.append("->");
//            return;
//        }
//        current.append(root.val).append("->");
//
//        if (root.left != null) {
//            findPathRec(root.left, current);
//
//            current.setLength(current.length() - findNumberOfChar(root.left.val) - 2);
//        }
//
//        if (root.right != null) {
//            findPathRec(root.right, current);
//            current.setLength(current.length() - findNumberOfChar(root.right.val) - 2);
//        }
//
//    }
//
//    private int findNumberOfChar(int val) {
//        int cnt = (val >= 0) ? 0 : 1;
//        while (val != 0) {
//            cnt++;
//            val /= 10;
//        }
//        return cnt;
//    }

    //solution2: refactor
    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        findPath(root, new StringBuilder(""));
        return res;
    }

    private void findPath(TreeNode node, StringBuilder path) {
        int len = path.length();         // 1. Ghi lại trạng thái ban đầu
        path.append(node.val);          // 2. Thay đổi trạng thái

        if (node.left == null && node.right == null) {
            res.add(path.toString());   // Nếu là lá, lưu kết quả
        } else {
            path.append("->");          // Thêm "->" cho nhánh con
            if (node.left != null) {
                findPath(node.left, path);   // 3. Đệ quy trái
            }
            if (node.right != null) {
                findPath(node.right, path);  // 4. Đệ quy phải
            }
        }

        path.setLength(len);            // 5. Phục hồi trạng thái ban đầu (rất quan trọng!)
    }
}
