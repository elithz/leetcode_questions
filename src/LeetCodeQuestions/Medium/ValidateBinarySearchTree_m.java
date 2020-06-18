package LeetCodeQuestions.Medium;

public class ValidateBinarySearchTree_m {


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

    static class Solution {

        public boolean isValidBST(TreeNode root) {
            int min = Integer.MIN_VALUE;
            int max = Integer.MAX_VALUE;
            // if(root == null) return true;
            // if(root.left == null && root.right == null && root != null) return true;

            return isBST(root, null, null);
        }

        //cant check min and max vals of int
        public static boolean helper(TreeNode node, int min, int max) {
            if (node == null)
                return true;

            if (node.val < min || node.val > max)
                return false;


            return (helper(node.left, min, node.val - 1) && helper(node.right, node.val, max + 1));
        }

        static boolean isBST(TreeNode root, TreeNode l, TreeNode r) {
            if (root == null)
                return true;

            if (l != null && root.val <= l.val)
                return false;

            if (r != null && root.val >= r.val)
                return false;

            return isBST(root.left, l, root) &&
                    isBST(root.right, root, r);
        }


    }
}
