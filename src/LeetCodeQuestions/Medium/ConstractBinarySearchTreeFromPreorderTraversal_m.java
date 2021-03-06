package LeetCodeQuestions.Medium;

public class ConstractBinarySearchTreeFromPreorderTraversal_m {

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
        int index = 0;

        public TreeNode bstFromPreorder(int[] preorder) {
            return treeBuilder(preorder, Integer.MAX_VALUE);

            // if (preorder == null || preorder.length == 0) {
            //     return null;
            // }
            // Stack<TreeNode> stack = new Stack<>();
            // TreeNode root = new TreeNode(preorder[0]);
            // stack.push(root);
            // for (int i = 1; i < preorder.length; i++) {
            //     TreeNode node = new TreeNode(preorder[i]);
            //     if (preorder[i] < stack.peek().val) {
            //         stack.peek().left = node;
            //     } else {
            //         TreeNode parent = stack.peek();
            //         while (!stack.isEmpty() && preorder[i] > stack.peek().val) {
            //             parent = stack.pop();
            //         }
            //         parent.right = node;
            //     }
            //     stack.push(node);
            // }
            // return root;

        }

        TreeNode treeBuilder(int[] preTree, int max) {
            if (index == preTree.length || preTree[index] > max) return null;

            TreeNode root = new TreeNode(preTree[index++]);

            root.left = treeBuilder(preTree, root.val);
            root.right = treeBuilder(preTree, max);

            return root;
        }
    }
}
