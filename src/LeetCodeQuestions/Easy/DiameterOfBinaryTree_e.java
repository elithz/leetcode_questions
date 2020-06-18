package LeetCodeQuestions.Easy;

public class DiameterOfBinaryTree_e {
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
        int ans;

        public int diameterOfBinaryTree(TreeNode root) {
            ans = 0;
            dfs(root);
            return ans;
        }

        int dfs(TreeNode root) {
            if (root == null) return 0;
            int left = dfs(root.left);
            int right = dfs(root.right);
            ans = Math.max(ans, right + left);
            return Math.max(left, right) + 1;
        }
    }
}
