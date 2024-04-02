package org.example.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    List<String> board=new ArrayList<>();
    List<List<String>> res=new ArrayList<>();
    List<List<String>> solveNQueens(int n){
        StringBuilder row=new StringBuilder();
        for (int i=0;i<n;i++){
            row.append(".");
        }
        for (int i=0;i<n;i++){
            board.add(row.toString());
        }
        backtrack(board,0,n);
        return res;
    }
    void backtrack(List<String> board,int row,int n){
        if (row==n){
            res.add(board);
            return;
        }
        for (int i=0;i<n;i++){
            if (!isValid(board,row,i)) continue;
            StringBuilder sb = new StringBuilder(board.get(row));
            sb.setCharAt(n, 'Q');
            board.set(row,sb.toString());
            backtrack(board,row+1,n);
            sb.setCharAt(n, '.');
            board.set(row,sb.toString());
        }
    }
    boolean isValid(List<String> board, int row, int col) {
        int n = board.size();
        // 检查列是否有皇后互相冲突
        for (int i = 0; i <= row; i++) {
            if (board.get(i).charAt(col) == 'Q')
                return false;
        }
        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q')
                return false;
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q')
                return false;
        }
        return true;
    }
}
