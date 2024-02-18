package org.example.OD;

import java.util.LinkedList;
import java.util.Scanner;

public class GoQi {
    void solution(){
        int[][] board = new int[19][19];    // 棋盘，用于表示每个位置的棋子状态，0:没有棋子 1:黑 2:白
        LinkedList<int[]> blackList = new LinkedList<>();  // 存储黑棋坐标的链表
        LinkedList<int[]> whiteList = new LinkedList<>();  // 存储白棋坐标的链表
        Scanner scanner = new Scanner(System.in);

        // 读入黑棋坐标，并在棋盘上标记黑棋位置
        String[] black = scanner.nextLine().split(" ");
        for (int i = 0; i < black.length; i += 2) {
            int x = Integer.parseInt(black[i]), y = Integer.parseInt(black[i + 1]);
            board[x][y] = 1;
            blackList.add(new int[]{x, y});
        }

        // 读入白棋坐标，并在棋盘上标记白棋位置
        String[] white = scanner.nextLine().split(" ");
        for (int i = 0; i < white.length; i += 2) {
            int x = Integer.parseInt(white[i]), y = Integer.parseInt(white[i + 1]);
            board[x][y] = 2;
            whiteList.add(new int[]{x, y});
        }

        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};  // 方向数组，用于表示上下左右四个方向

        // 计算黑棋的气数
        int blackQi = 0;
        for (int i = 0; i < blackList.size(); ++i) {
            int x = blackList.get(i)[0], y = blackList.get(i)[1];
            for (int k = 0; k < 4; ++k) {
                int nx = x + dir[k][0], ny = y + dir[k][1];
                if (0 <= nx && nx < 19 && 0 <= ny && ny < 19 && board[nx][ny] == 0) {
                    board[nx][ny] = 3;  // 标记为临时状态3，表示该位置属于黑棋的气
                    blackQi += 1;       // 增加黑棋的气数
                }
            }
        }

        // 计算白棋的气数
        int whiteQi = 0;
        for (int i = 0; i < whiteList.size(); ++i) {
            int x = whiteList.get(i)[0], y = whiteList.get(i)[1];
            for (int k = 0; k < 4; ++k) {
                int nx = x + dir[k][0], ny = y + dir[k][1];
                if (0 <= nx && nx < 19 && 0 <= ny && ny < 19 && (board[nx][ny] == 0 || board[nx][ny] == 3)) {
                    board[nx][ny] = 4;  // 标记为临时状态4，表示该位置属于白棋的气
                    whiteQi += 1;       // 增加白棋的气数
                }
            }
        }

        System.out.println(blackQi + " " + whiteQi);  // 输出黑棋和白棋的气数
    }
    public static void main(String[] args) {
        int [][] p =new int[19][19];
        Scanner scanner = new Scanner(System.in);
        String[] black = scanner.nextLine().split(" ");
        String[] white = scanner.nextLine().split(" ");
        int b1=0;
        while (b1<black.length){
            int i=Integer.parseInt(black[b1]);
            b1++;
            int j=Integer.parseInt(black[b1]);
            b1++;
            p[i][j]=1;
        }
        int w1=0;
        while (w1<white.length){
            int i=Integer.parseInt(black[w1]);
            w1++;
            int j=Integer.parseInt(black[w1]);
            w1++;
            p[i][j]=2;
        }
        int blackQi=0;
        for (int i=0;i<19;i++){
            for (int j=0;j<19;j++){
                if (p[i][j]==1){
                    if(i-1>0 && p[i-1][j]!=3){p[i-1][j]=3;blackQi++;}
                    if(j-1>0 && p[i][j-1]!=3){p[i][j-1]=3;blackQi++;}
                    if(p[i+1][j]!=3){p[i+1][j]=3;blackQi++;}
                    if(p[i][j+1]!=3){p[i][j+1]=3;blackQi++;}
                }
            }
        }
    }
}
