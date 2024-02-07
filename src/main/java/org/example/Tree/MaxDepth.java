package org.example.Tree;

import org.example.struct.TreeNode;

import java.util.Map;

public class MaxDepth {
    /**
     * 解法1:遍历
     */
    int depth=0;
    int maxDeep=0;
    int maxDepth(TreeNode root){
        traverse(root);
        return maxDeep;
    }
    void traverse(TreeNode tree){
        if (tree==null) return;
        depth=depth+1;
        if (tree.left==null&&tree.right==null){
            maxDeep=Math.max(depth,maxDeep);
        }
        traverse(tree.left);
        traverse(tree.right);
        depth=depth-1;
    }

    /**
     * 解法2:分解问题
     */
    int getMaxDeep(TreeNode root){
        if (root==null) return 0;
        int maxl=getMaxDeep(root.left);
        int maxr=getMaxDeep(root.right);
        return Math.max(maxr,maxl)+1;
//        return 0;
    }
}
