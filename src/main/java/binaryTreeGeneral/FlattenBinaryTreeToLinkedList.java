/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binaryTreeGeneral;

/**
 *
 * @author FPT
 */
public class FlattenBinaryTreeToLinkedList {
    TreeNode prev = null; // Ghi nhớ node trước đó trong quá trình duyệt

    public void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.right); // Duyệt phải trước
        flatten(root.left);  // Duyệt trái sau

        root.right = prev;   // Nối node hiện tại với node trước đó
        root.left = null;    // Bỏ liên kết trái
        prev = root;         // Cập nhật node trước
    }
}
