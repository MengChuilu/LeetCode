package q099;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mengchuilu
 */
public class Solution {

    List<TreeNode> cache = new ArrayList<>();
    List<TreeNode[]> backUp = new ArrayList<>();

    public void recoverTree(TreeNode root) {
        inOrder(root);

        for (int i = 0;i < cache.size() - 1;i ++) {
            if (cache.get(i).val > cache.get(i + 1).val) {
                backUp.add(new TreeNode[]{cache.get(i), cache.get(i + 1)});
            }
        }

        if (backUp.size() == 1) {
            int t = backUp.get(0)[0].val;
            backUp.get(0)[0].val = backUp.get(0)[1].val;
            backUp.get(0)[1].val = t;
        }
        else {
            int t = backUp.get(0)[0].val;
            backUp.get(0)[0].val = backUp.get(1)[1].val;
            backUp.get(1)[1].val = t;
        }
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        cache.add(root);
        inOrder(root.right);
    }
}