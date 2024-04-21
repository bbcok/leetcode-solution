package org.example.OD;

import java.util.Scanner;

public class InfectAll {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String in=scanner.nextLine();
        if (!in.contains("1")) {
            System.out.println(-1);
            return;
        }
        solution(in);
    }
    static void solution(String s)
    {
        String [] split=s.split(",");
        int n=(int) Math.sqrt(split.length);
        int[][] mapGrid = new int[n][n];
        int k = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; j++) {
                mapGrid[i][j] = Integer.parseInt(split[k++]);
            }
        }
        int count = 0;
        while (isAllInfect(mapGrid)){
            infect(mapGrid);
            count++;
        }
        System.out.println(count);
    }
    public static void infect(int[][] mapGrid) {
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < mapGrid.length; i++){
            for (int j = 0; j < mapGrid[0].length; j++){
                if (mapGrid[i][j]==1){
                    for (int[] dir : dirs){
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x >= 0 && x < mapGrid.length && y >= 0 && y < mapGrid[0].length && mapGrid[x][y] == 0){
                            mapGrid[x][y] = 2;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < mapGrid.length; i++){
            for (int j = 0; j < mapGrid[0].length; j++){
                if (mapGrid[i][j]==2){
                    mapGrid[i][j] = 1;
                }
            }
        }
    }
    public static boolean isAllInfect(int[][] mapGrid) {
        for (int i = 0; i < mapGrid.length; i++){
            for (int j=0; j < mapGrid[0].length; j++){
                if (mapGrid[i][j] == 0) return true;
            }
        }
        return false;
    }
}
