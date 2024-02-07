package org.example.LinkedList;

public class RemoveDuplicates {
    int removeDuplicates(int[] nums){
        int p=0;
        int j=1;
        while (j<nums.length){
            if (nums[p]==nums[j]){
                j++;
            }
            else {
                nums[p]=nums[j];
                p++;
            }
        }
        return p+1;
    }
}
