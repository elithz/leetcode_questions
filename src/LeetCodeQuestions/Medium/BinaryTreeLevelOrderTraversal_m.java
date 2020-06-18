package LeetCodeQuestions.Medium;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal_m {
    public class TreeNode {
        int val;
        BinaryTreeLevelOrderTraversal_m.TreeNode left;
        BinaryTreeLevelOrderTraversal_m.TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, BinaryTreeLevelOrderTraversal_m.TreeNode left, BinaryTreeLevelOrderTraversal_m.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {

        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            int height = height(root);
            for (int i = 1; i <= height; i++) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                ansBuilder(temp, root, i);
                ans.add(temp);
            }
            return ans;
        }

        static int height(TreeNode root) {
            if (root == null)
                return 0;
            else {
                int lheight = height(root.left);
                int rheight = height(root.right);

                if (lheight > rheight)
                    return (lheight + 1);
                else return (rheight + 1);
            }
        }

        static void ansBuilder(ArrayList<Integer> temp, TreeNode root, int level) {
            if (root == null)
                return;
            if (level == 1) {
                temp.add(root.val);
            } else if (level > 1) {
                ansBuilder(temp, root.left, level - 1);
                ansBuilder(temp, root.right, level - 1);
            }
        }
    }
}
