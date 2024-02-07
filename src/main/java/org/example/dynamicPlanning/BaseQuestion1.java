package org.example.dynamicPlanning;

import java.util.Arrays;

public class BaseQuestion1 {
    int longestPalindromeSubseq(String s){
        
        return 0;
    }
    int LongestIncreasingSubsequence(int[] s){
        int n=s.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        for (int i=0;i<n;i++){
            for (int j=0;j<i;j++){
                if(s[j]<s[i]) dp[i]=Math.max(dp[j]+1,dp[i]);
            }
        }
        int re=0;
        for (int i=0;i<n;i++){
            re=Math.max(re,dp[i]);
        }
        return re;
    }
    public static void main(String[] args) {
        String device_type = "DM,N";
        String tableName = "NE_SDH,NE_DWDM,NE_IP".contains(device_type) ? "equipment_temp" : "im_fbbdev_temp";
        System.out.println(tableName);
    }
}
