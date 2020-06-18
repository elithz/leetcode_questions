package LeetCodeQuestions.Hard;

public class BinaryTreeMaxinumPathSum_h {
    static class Solution {

        static int max;

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

        public int maxPathSum(TreeNode root) {
            max = Integer.MIN_VALUE;
            dfs(root);
            return max;
        }

        int dfs(TreeNode root) {
            if (root == null) return 0;
            int left = Math.max(0, dfs(root.left));
            int right = Math.max(0, dfs(root.right));
            max = Math.max(max, left + right + root.val);
            return Math.max(left, right) + root.val;
        }

    }
}
