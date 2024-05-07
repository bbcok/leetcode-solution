package org.example.OD;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PrintNums {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
        solve(6);
    }
    static void solve(int n)
    {
        int num = 1;
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            String str = "";
            for (int j=0;j<i;j++){

                if(i%2==0){
                        str = num+" "+str;
                }else {
                        str = str+" "+num;
                }
                num++;
            }
            list.add(str.trim());
//            System.out.println(str.trim());

        }

        LinkedList<String> strList = new LinkedList<>();
        String blank = "";
        for (int i = list.size()-1; i >= 0; i--){
            String[] s = list.get(i).split(" ");
            StringBuilder str = new StringBuilder(blank);
            for (int j = 0; j < s.length; j++){
                str.append(s[j]);
                for (int k = 0; k<4-s[j].length(); k++){
                    str.append("*");
                }
                str.append("    ");
            }
            blank = blank+"    ";
//            System.out.println(str);
            strList.push(str.toString());
        }
        while (!strList.isEmpty()){
            System.out.println(strList.pop());
        }
    }

}
