package org.example.recurrence;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combine1 {
     List<List<Integer>> result = new ArrayList<>();
     LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k){
        f(n, k, 1);
        return result;
    }
    public void f(int n, int k, int start){
        if(path.size()==k){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=start;i<=n-(k-path.size())+1;i++){
            path.add(i);
            f(n, k, i+1);
            path.removeLast();
        }
    }


}
