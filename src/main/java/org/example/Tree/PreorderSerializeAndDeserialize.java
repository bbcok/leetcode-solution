package org.example.Tree;

import org.example.struct.TreeNode;

public class PreorderSerializeAndDeserialize {
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        f(root, sb);
        return sb.toString();
    }
    public static void f(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("#,");
        }else {
            sb.append(root.val + ",");
            f(root.left, sb);
            f(root.right, sb);
        }
    }
    public static int cnt;
    public static TreeNode deserialize(String data) {
        String[] nums = data.split(",");
        cnt = 0;
        return buildTree(nums);
    }
    public static TreeNode buildTree(String[] nums) {
        String cur = nums[cnt++];
        if(cur.equals("#")){
            return null;
        }else{
            TreeNode root = new TreeNode(Integer.parseInt(cur));
            root.left = buildTree(nums);
            root.right = buildTree(nums);
            return root;
        }
    }
}
