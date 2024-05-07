package org.example.OD;

import java.util.*;

public class DecryptCrimeTime {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String tiem = scanner.nextLine();
        solution(tiem);
    }
    static void solution(String time){
        List<Integer> nums = new ArrayList<>();
        for (char c : time.toCharArray()) {
            if (c != ':') {
                nums.add(Character.getNumericValue(c));
            }
        }
        String[] timeParts = time.split(":");
        int h = Integer.parseInt(timeParts[0]);
        int m = Integer.parseInt(timeParts[1]);

        // 生成所有可能的有效时间组合
        List<Integer> lst = new ArrayList<>();
        for (int i : nums) {
            for (int j : nums) {
                if (i <= 5) {
                    lst.add(i * 10 + j);
                }
            }
        }

        Collections.sort(lst);
        for (int i = 0; i < lst.size(); i++){
            if (lst.get(i) > m) {
                System.out.println( h + ":" + lst.get(i));
                return;
            }
        }
        if (h!=23){
            for (int i = 0; i < lst.size(); i++){
                if (lst.get(i) > h) {
                    System.out.println( lst.get(i)+ ":" +m);
                    return;
                }
            }
        }
    }
}
