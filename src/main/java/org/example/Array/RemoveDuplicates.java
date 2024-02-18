package org.example.Array;

public class RemoveDuplicates {
    int removeDuplicates(int[] num){
        int slow=0;
        int fast=0;
        while (fast<num.length){
            if(num[slow]!=num[fast]){
                slow++;
                // 维护 nums[0..slow] 无重复
                num[slow] = num[fast];
            }
            fast++;
        }
        return slow+1;
    }
    public void exchange(int[] num,int i,int j){
        int tmp=num[i];
        num[i]=num[j];
        num[j]=tmp;
    }

}
