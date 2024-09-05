package org.example.Tree;

import org.example.struct.TreeNode;

public class ValidateBinarySearchTree {
    public static boolean isValidBST(TreeNode root)
    {
        return f(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public static boolean f(TreeNode cur,long min,long max){
        if(cur==null){
            return true;
        }
        if(cur.val<=min||cur.val>=max){
            return false;
        }
        return f(cur.left,min,cur.val)&&f(cur.right,cur.val,max);
    }
}
