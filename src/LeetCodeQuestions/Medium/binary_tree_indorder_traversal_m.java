package LeetCodeQuestions.Medium;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class binary_tree_indorder_traversal_m {
    public static List<Integer> ans;
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(Arrays.toString(inoderIterate(root).toArray()));
    }

    public static List<Integer> inorderTraversal(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        addInorder(root, ans);
        return ans;
    }

    public static void addInorder(TreeNode node, List<Integer> ans){
        if(node == null)
            return;
        addInorder(node.left, ans);
        ans.add(node.val);
        addInorder(node.right, ans);
    }

    public static List<Integer> inoderIterate(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null || stack.size() > 0){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            ans.add(curr.val);
            curr = curr.right;
        }
        return ans;
    }
}
