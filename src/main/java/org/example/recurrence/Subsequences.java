package org.example.recurrence;

import java.util.HashSet;

public class Subsequences {

    public static String[] generatePermutation1(String str){
        HashSet<String> set=new HashSet<>();
        return null;
    }
    static String[] ans;
    public static void f(char[] s,int i,HashSet<String> set,StringBuilder path){
        if(i==s.length){
            set.add(path.toString());
        }
    }
}
