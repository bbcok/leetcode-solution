package org.example.Tree;

import org.example.struct.TreeNode;

public class BalancedBinaryTree {
    static boolean isBalanced;
    public static boolean isBalanced(TreeNode root){
        isBalanced = true;
        f(root);
        return isBalanced;
    }
    static int f(TreeNode cur){
        if(!isBalanced||cur==null){
            return 0;
        }
        int left=f(cur.left);
        int right=f(cur.right);
        if(Math.abs(left-right)>1){
            isBalanced=false;
        }
        return Math.max(left,right)+1;
    }
}
