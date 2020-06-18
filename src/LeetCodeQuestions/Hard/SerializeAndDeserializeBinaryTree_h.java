package LeetCodeQuestions.Hard;

import java.util.*;

public class SerializeAndDeserializeBinaryTree_h {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        Codec codec = new Codec();
        codec.deserialize(codec.serialize(root));
    }

    //    public static class Codec {
//
//        // Encodes a tree to a single string.
//        public String serialize(TreeNode root) {
//
//            class Local {
//                String preorder = "";
//                String inorder = "";
//
//                public void dfsPre(TreeNode node) {
//                    if (node == null) return;
//                    preorder += ":" + node.val;
//                    dfsPre(node.left);
//                    dfsPre(node.right);
//                }
//
//                public void dfsIn(TreeNode node) {
//                    if (node == null) return;
//                    dfsIn(node.left);
//                    inorder += ":" + node.val;
//                    dfsIn(node.right);
//                }
//            }
//
//            Local local = new Local();
//            local.dfsPre(root);
//            local.dfsIn(root);
//            System.out.println(local.preorder + local.inorder);
//            return local.preorder + local.inorder;
//        }
//
//
//        // Decodes your encoded data to tree.
//        public TreeNode deserialize(String data) {
//            if (data.equals("")) return null;
//            class Solution {
//                int preIndex = 0;
//
//                TreeNode buildTree(int in[], int pre[], int inStrt, int inEnd) {
//                    if (inStrt > inEnd)
//                        return null;
//
//                    TreeNode tNode = new TreeNode(pre[preIndex++]);
//
//                    if (inStrt == inEnd)
//                        return tNode;
//
//                    int inIndex = search(in, inStrt, inEnd, tNode.val);
//
//                    tNode.left = buildTree(in, pre, inStrt, inIndex - 1);
//                    tNode.right = buildTree(in, pre, inIndex + 1, inEnd);
//
//                    return tNode;
//                }
//
//                int search(int arr[], int strt, int end, int value) {
//                    int i;
//                    for (i = strt; i <= end; i++) {
//                        if (arr[i] == value)
//                            return i;
//                    }
//                    return i;
//                }
//            }
//
//            System.out.println("\"" + data + "\": this is data");
//            int[] vals = Arrays.stream(data.substring(1).split(":")).mapToInt(Integer::parseInt).toArray();
//            for (int i : vals) System.out.print(i + " ");
//            System.out.println();
//            int[] preorder = Arrays.copyOfRange(vals, 0, vals.length / 2);
//            for (int i : preorder) System.out.print(i + " ");
//            System.out.println();
//            int[] inorder = Arrays.copyOfRange(vals, vals.length / 2, vals.length);
//            for (int i : inorder) System.out.print(i + " ");
//            Solution solution = new Solution();
//            return solution.buildTree(inorder, preorder, 0, inorder.length - 1);
//        }
//    }
    public static class Codec {
        private static final String spliter = ",";
        private static final String NN = "X";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            buildString(root, sb);
            return sb.toString();
        }

        private void buildString(TreeNode node, StringBuilder sb) {
            if (node == null) {
                sb.append(NN).append(spliter);
            } else {
                sb.append(node.val).append(spliter);
                buildString(node.left, sb);
                buildString(node.right, sb);
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Deque<String> nodes = new LinkedList<>();
            nodes.addAll(Arrays.asList(data.split(spliter)));
            return buildTree(nodes);
        }

        private TreeNode buildTree(Deque<String> nodes) {
            String val = nodes.remove();
            if (val.equals(NN)) return null;
            else {
                TreeNode node = new TreeNode(Integer.valueOf(val));
                node.left = buildTree(nodes);
                node.right = buildTree(nodes);
                return node;
            }
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
