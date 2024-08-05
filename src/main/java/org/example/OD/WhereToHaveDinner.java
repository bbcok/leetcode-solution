package org.example.OD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WhereToHaveDinner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int j = scanner.nextInt();
        int[][] input = new int[i][j];
        List<int[]> destination = new ArrayList<>();
        List<int[]> hwPosition = new ArrayList<>();
        for (int k = 0; k < i; k++){
            for (int l = 0; l < j; l++){
                int number=scanner.nextInt();
                input[k][l]=number;
                if (number==2){
                    hwPosition.add(new int[]{k,l});
                }
                if (number==3){
                    destination.add(new int[]{k,l});
                }
            }
        }

    }
}
