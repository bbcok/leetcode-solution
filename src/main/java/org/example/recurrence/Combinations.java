package org.example.recurrence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {
    public static List<List<Integer>> subsetsWithDup(int[] nums)
    {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        f(nums, 0, new int[nums.length], 0, ans);
        return ans;
    }
    public static void f(int[] nums, int i, int[] path, int size, List<List<Integer>> ans)
    {
        if(i==nums.length){

        }
    }
}
