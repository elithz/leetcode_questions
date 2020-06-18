package LeetCodeQuestions.Easy;

public class InvertBinaryTree_e {

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

    class Solution {
        public TreeNode invertTree(TreeNode root) {
            return dfs(root);
        }

        TreeNode dfs(TreeNode root) {
            if (root == null) return null;
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;
            dfs(root.right);
            dfs(root.left);
            return root;
        }
    }
}
