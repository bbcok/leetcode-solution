package org.example.OD;

import java.util.*;

public class Lookforchildrensimilarheight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();

        String [] m = s1.split(" ");
        String[] height = s2.split(" ");

        Map<Integer,Integer> map=new HashMap<>(Integer.parseInt(m[1]));
        int a=Integer.parseInt(m[0]);
        for (String s:height){
            map.put(Integer.parseInt(s),Math.abs(Integer.parseInt(s)-a));
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByKey());
        list.sort(Map.Entry.comparingByValue());
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<list.size();i++){
            if (i==list.size()-1){
                sb.append(list.get(i).getKey());
            }else {
                sb.append(list.get(i).getKey());
                sb.append(" ");
            }
        }
        System.out.println(sb);

    }
}
