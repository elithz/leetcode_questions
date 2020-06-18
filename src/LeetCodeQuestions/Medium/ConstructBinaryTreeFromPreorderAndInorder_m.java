package LeetCodeQuestions.Medium;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorder_m {
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = 0; i < inorder.length; i++)
                map.put(inorder[i], i);
            return treeBuilder(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
        }

        TreeNode treeBuilder(int[] preTree, int preStart, int preEnd, int[] inTree, int inStart, int inEnd, Map<Integer, Integer> inMap) {
            if (preStart > preEnd || inStart > inEnd) return null;

            TreeNode root = new TreeNode(preTree[preStart]);
            int inRoot = inMap.get(root.val);
            int numsLeft = inRoot - inStart;

            root.left = treeBuilder(preTree, preStart + 1, preStart + numsLeft, inTree, inStart, inRoot - 1, inMap);
            root.right = treeBuilder(preTree, preStart + numsLeft + 1, preEnd, inTree, inRoot + 1, inEnd, inMap);

            return root;
        }
    }
}
