package org.example.Tree;

import org.example.struct.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PreOrderInorderBuildTree {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return f(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
    }
    public static TreeNode f(int[]pre,int l1,int r1,int[]in,int l2,int r2,Map<Integer,Integer> map){
        if(l1>r1) {
            return null;
        }
        TreeNode root=new TreeNode(pre[l1]);
        if(l1==r1){
            return root;
        }
        int mid=map.get(pre[l1]);
        root.left=f(pre,l1+1,l1+mid-l2,in,l2,mid-1,map);
        root.right=f(pre,l1+mid-l2+1,r1,in,mid+1,r2,map);
        return root;
    }
}
