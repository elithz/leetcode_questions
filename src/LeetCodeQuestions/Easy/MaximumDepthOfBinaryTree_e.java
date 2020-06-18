package LeetCodeQuestions.Easy;

public class MaximumDepthOfBinaryTree_e {
    static class Solution {
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

        public int maxDepth(TreeNode root) {
            return getHeight(root);
        }

        static int getHeight(TreeNode root) {
            if (root == null)
                return 0;
            else {
                int lheight = getHeight(root.left);
                int rheight = getHeight(root.right);
                if (lheight > rheight)
                    return lheight + 1;
                else
                    return rheight + 1;
            }
        }
    }
}
