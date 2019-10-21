package q098;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
//    public boolean isValidBST(TreeNode root) {
//
//        List<Integer> data = new ArrayList<>();
//        preOrder(root, data);
//        for (int i = 0;i < data.size() - 1;i ++) {
//            if (data.get(i) > data.get(i+1)) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//    private void preOrder(TreeNode root, List<Integer> data) {
//        if (root != null) {
//            preOrder(root.left, data);
//            data.add(root.val);
//            preOrder(root.right, data);
//        }
//    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode pre = getPre(root);
        TreeNode next = getNext(root);
        boolean subResult = (pre == null || root.val > pre.val) && (next == null || root.val < next.val);

        return isValidBST(root.left) && isValidBST(root.right) && subResult;
    }

    private TreeNode getPre(TreeNode node) {
        if (node == null) {
            return null;
        }

        TreeNode pre = node.left;
        while (pre != null && pre.right != null) {
            pre = pre.right;
        }

        return pre;
    }

    private TreeNode getNext(TreeNode node) {
        if (node == null) {
            return null;
        }

        TreeNode next = node.right;
        while (next != null && next.left != null) {
            next = next.left;
        }

        return next;
    }
}