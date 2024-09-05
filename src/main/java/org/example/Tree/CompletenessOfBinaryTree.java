package org.example.Tree;

import org.example.struct.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class CompletenessOfBinaryTree {

    public static boolean isCompleteTree(TreeNode root)
    {
        Deque<TreeNode> q=new LinkedList<>();
        if(root==null) return true;
        q.addLast(root);
        boolean flag=false;
        while(!q.isEmpty())
        {
            TreeNode cur=q.pollFirst();
            if(cur.left==null && cur.right!=null){
                return false;
            }

            if(flag && cur.left!=null){
                return false;
            }
            if (cur.left!=null){
                q.addLast(cur.left);
            }
            if(cur.right!=null){
                q.addLast(cur.right);
            }

            if(!flag && cur.right==null){
                flag=true;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        int[] nums2 = {1,2,3,4,5,6};
        TreeNode root = BinaryTree.buildTree(nums2);
        System.out.println(isCompleteTree(root));
    }
}
