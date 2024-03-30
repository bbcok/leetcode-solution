package org.example.OD;

import java.util.Map;
import java.util.Scanner;

public class MaxMale {
    int solve(char[][] input){
        int m=input.length;
        int n=input[0].length;
        int[][][] dp=new int[m][n][3];
        dp[0][0][0]=input[0][0]=='M'?1:0;
        int max=0;
        for (int i=0;i<m;i++){
            if (input[i][0]=='M'){
                dp[i][0][0]=dp[i-1][0][0]+1;
                dp[i][0][1]=1;
                dp[i][0][2]=1;
            }
        }
        for (int i=0;i<n;i++){
            if (input[0][i]=='M'){
                dp[0][i][0]=1;
                dp[0][i][1]=dp[0][i-1][0]+1;
                dp[0][i][2]=1;
            }
        }
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){

                if (input[i][j]=='M'){
                    dp[i][j][0]=dp[i-1][j][0]+1;
                    dp[i][j][1]=dp[i][j-1][1]+1;
                    dp[i][j][2]=dp[i-1][j-1][2]+1;
                }
                for (int k=0;k<3;k++){
                    max= Math.max(max,dp[i][j][k]);
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] size=scanner.nextLine().split(",");
        int x = Integer.parseInt(size[0]);
        int y = Integer.parseInt(size[1]);
        char[][] square = new char [x][y];
        for (int i=0;i<x;i++){
            square[i] = scanner.nextLine().replaceAll(",", "").toCharArray();
        }

        MaxMale maxMale = new MaxMale();
        int res = maxMale.solve(square);
        System.out.println(res);
    }
}
