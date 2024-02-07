package org.example.Tree;

import com.sun.source.tree.Tree;
import org.example.struct.TreeNode;

public class DiameterOfBinaryTree {
    int maxDiameter = 0;
    int presentMaxDiameter=0;
    int maxDeepth(TreeNode root){
        if(root==null) return 0;
        int maxl=maxDeepth(root.left);
        int maxr=maxDeepth(root.right);
        presentMaxDiameter = maxl+maxr;
        maxDiameter = Math.max(presentMaxDiameter,maxDiameter);
        return Math.max(maxl,maxr)+1;
    }
    int diameterOfBinaryTree(TreeNode root){
        maxDeepth(root);
        return maxDiameter;
    }
}
