package org.example.Tree;

import org.example.struct.TreeNode;

import java.util.*;

public class WidthOfBinaryTree {
    public static int widthOfBinaryTree(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        Deque<Integer> count = new LinkedList<>();
        int ans =1;
        if (root != null) {
            queue.offer(root);
            count.offer(1);
            while(!queue.isEmpty()){
                int size = queue.size();
                ans=Math.max(ans,count.getLast()-count.getFirst()+1);
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    int index = count.poll();
                    if (node.left != null){
                        count.offer(index*2);
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        count.offer(index*2+1);
                        queue.offer(node.right);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = BinaryTree.buildTree(new String[] {"1", "3", "2", "5", "null", "null", "9", "6", "null", "7"});
        int res = widthOfBinaryTree(root);
        System.out.println(res);
    }
}
