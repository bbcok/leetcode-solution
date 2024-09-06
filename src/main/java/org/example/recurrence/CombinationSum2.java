package org.example.recurrence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        Arrays.sort(candidates);
        f(candidates, 0, target, 0,new boolean[candidates.length]);
        return ans;
    }
    public void f(int[] candidates, int sum, int target, int i,boolean[] used){
        if(sum == target){
            ans.add(new ArrayList<>(path));
            return;
        }
//        if(sum>target) return;
        for(int j=i;j<candidates.length && sum+candidates[j]<=target;j++){
            if(j>0 && candidates[j]==candidates[j-1] && !used[j-1]){
                continue;
            }
            path.add(candidates[j]);
            used[j]=true;
            f(candidates,sum+candidates[j],target,j+1,used);
            path.remove(path.size()-1);
            used[j]=false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum2().combinationSum(new int[]{1,1,2,7,6,1,5},8));
    }
}
