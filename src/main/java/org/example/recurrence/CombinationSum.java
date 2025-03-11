package org.example.recurrence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        Arrays.sort(candidates);
        f(candidates, 0, target, 0);
        return ans;
    }
    public void f(int[] candidates,int sum, int target, int i){
        if(sum == target){
            ans.add(new ArrayList<>(path));
        }
        if(sum>target) {
            return;
        }
        for(int j=i;j<candidates.length;j++){
            path.add(candidates[j]);
            f(candidates, sum+candidates[j], target, j);
            path.remove(path.size()-1);
        }
    }
    public static void main(String[] args)
    {
        System.out.println(new CombinationSum().combinationSum(new int[]{2,3,6,7}, 7));
    }
}
