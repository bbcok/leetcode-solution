package org.example.Tree;

import org.example.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    static List<List<Integer>> ans;
    public static List<List<Integer>> pathSum(TreeNode root, int aim) {
        List<Integer> path = new ArrayList<>();
        f(root, aim, 0,path);
        return ans;
    }
    public static void f(TreeNode cur, int aim, int sum, List<Integer> path){
        if(cur.right==null && cur.left==null){
            if(aim==sum+cur.val){
                path.add(cur.val);
                copy(path,ans);
                path.remove(path.size()-1);
            }
        }else{
            path.add(cur.val);
            if(cur.left!=null){
                f(cur.left,aim,sum+cur.val,path);
            }
            if(cur.right!=null){
                f(cur.right,aim,sum+cur.val,path);
            }
            path.remove(path.size()-1);
        }
    }
    private static void copy(List<Integer> path,List<List<Integer>> ans){
        List<Integer> tmp = new ArrayList<>();
        for(int i:path){
            tmp.add(i);
        }
        ans.add(tmp);
    }

}
