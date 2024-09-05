package org.example.Tree;

import org.example.struct.TreeNode;

import javax.swing.*;

public class HouseRobberIII {
    public static int rob(TreeNode root)
    {
        f(root);
        return Math.max(yes,no);
    }
    static int yes;
    static int no;
    public static void f(TreeNode cur){
        if(cur==null){
            yes=0;
            no=0;
        }else{
            int y=cur.val;
            int n=0;
            f(cur.left);
            y+=no;
            n+=Math.max(yes,no);
            f(cur.right);
            y+=no;
            n+=Math.max(yes,no);
            yes=y;
            no=n;
        }
    }
}
