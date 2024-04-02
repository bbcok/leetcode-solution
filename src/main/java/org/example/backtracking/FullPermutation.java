package org.example.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FullPermutation {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permutation(int[] nums){
        List<Integer> re=new ArrayList<>();
        backtrack(re,nums);
        return res;
    }
    void backtrack(List<Integer> re,int[] nums){
        if (re.size()==nums.length){
            res.add(new ArrayList<>(re));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (re.contains(nums[i])) continue;
            re.add(nums[i]);
            backtrack(re,nums);
            re.remove(re.size()-1);
        }
    }

    public List<List<Integer>> permutationDuplicate(int[] nums){
        List<Integer> re=new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrackDuplicate(re,nums,used);
        return res;
    }
    void backtrackDuplicate(List<Integer> re,int[] nums,boolean[] used){
        if (re.size()==nums.length){
            res.add(new ArrayList<>(re));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (!used[i]){
                if (i>0&&nums[i-1]==nums[i]&&!used[i-1]) continue;
                re.add(nums[i]);
                used[i]=true;
                backtrackDuplicate(re,nums,used);
                re.remove(re.size()-1);
                used[i]=false;
            }
        }
    }
    public static void main(String[] args) {
        FullPermutation fullPermutation = new FullPermutation();
        List<List<Integer>> a=fullPermutation.permutationDuplicate(new int[]{1,3,3});
        for (List<Integer> i:a){
            System.out.println(i.toString());
        }
    }
}
