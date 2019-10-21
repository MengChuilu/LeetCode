package q100;

import base.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author mengchuilu
 */
public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<TreeNode> queue1 = new LinkedList<>();
        Deque<TreeNode> queue2 = new LinkedList<>();

        queue1.addLast(p);
        queue2.addLast(q);

        while(!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode headp = queue1.removeFirst();
            TreeNode headq = queue2.removeFirst();

            if (headp == null && headq == null) {
                continue;
            }

            if (headp != null && headq != null && headp.val == headq.val) {
                queue1.addLast(headp.left);
                queue1.addLast(headp.right);
                queue2.addLast(headq.left);
                queue2.addLast(headq.right);

                continue;
            }


            return false;
        }

        return queue1.isEmpty() && queue2.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        Solution solution = new Solution();
        solution.isSameTree(treeNode1, treeNode1);
    }

    // ArrayDeque居然不支持空
}
