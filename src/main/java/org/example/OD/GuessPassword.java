package org.example.OD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GuessPassword {
    void generateComposition(int[] nums,int minN){
        minSize = minN;
        backtrack(nums,0);
        System.out.println("-");
        for (List<Integer> l:lines){
            for (int i=0;i<l.size();i++){
                System.out.print(l.get(i));
                if (i<l.size()-1) System.out.print(",");
            }
            System.out.println();
        }
    }
    List<Integer> line=new ArrayList<>();
    List<List<Integer>> lines=new ArrayList<>();
    int minSize;
    void backtrack(int[] nums,int start){
        if (line.size()>=minSize){
            lines.add(new ArrayList<>(line));
        }
        for (int i=start;i<nums.length;i++){
            line.add(nums[i]);
            backtrack(nums,i+1);
            line.remove(line.size()-1);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nums = scanner.nextLine().split(",");
        String minN = scanner.nextLine();
        int [] ints=new int[nums.length];
        for (int i=0;i<nums.length;i++){
            ints[i]=Integer.parseInt(nums[i]);
        }
        GuessPassword password=new GuessPassword();
        password.generateComposition(ints,Integer.parseInt(minN));
    }
}
