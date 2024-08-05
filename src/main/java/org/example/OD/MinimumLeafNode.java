package org.example.OD;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MinimumLeafNode {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        minimumLeafNode(s);
    }
    public static void minimumLeafNode(String s)
    {
        s="0 "+s;
        String[] split = s.split(" ");
        int n = split.length;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 2; i < split.length; ++i) {
            int tmp = Integer.parseInt(split[i]);
            if (tmp != 0 && tmp != -1) {
                heap.offer(tmp);
            }
        }
        int min = heap.peek();
        int minIndex=0;
        for (int i = 1; i < split.length; ++i){
            if (min == Integer.parseInt(split[i])){
                minIndex=i;
                break;
            }
        }
        while (minIndex!=1){
            System.out.println(split[minIndex]);
            if (minIndex%2==0){
                minIndex=minIndex/2;
            }else {
                minIndex=(minIndex-1)/2;
            }
        }
        System.out.println(split[1]);
    }
}
