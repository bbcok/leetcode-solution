package org.example.Tree;


import org.example.struct.TreeNode;
import java.util.LinkedList;
import java.util.Queue;


public class BinaryTree {
    public static TreeNode buildTree(String[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(nums[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < nums.length) {
            TreeNode node = queue.poll();

            if (i < nums.length && nums[i] != null) {
                if(nums[i].equals("null")) {
                    i++;
                }else {
                    node.left = new TreeNode(Integer.parseInt(nums[i]));
                    queue.offer(node.left);
                    i++;
                }
            }


            if (i < nums.length && nums[i] != null) {
                if(nums[i].equals("null")) {
                    i++;
                }else{
                    node.right = new TreeNode(Integer.parseInt(nums[i]));
                    queue.offer(node.right);
                    i++;
                }
            }
        }

        return root;
    }
    public static TreeNode buildTree(int[] nums){
        String[] strs = new String[nums.length];
        for(int i = 0;i < nums.length;i++){
            strs[i] = String.valueOf(nums[i]);
        }
        return buildTree(strs);
    }
    public static void main(String[] args) {
        String[] nums = {"1", "3", "2", "5", "null", "null", "9", "6", "null", "7"};
        TreeNode root = buildTree(nums);

        // 打印二叉树（示例）
        printTree(root);
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                System.out.print(node.val + " ");
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                System.out.print("null ");
            }
        }
    }
}
