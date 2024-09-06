package org.example.recurrence;

import java.util.ArrayList;
import java.util.List;

public class Partition {
    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s){
        f(s,0);
        return ans;
    }
    public void f(String s, int startIndex){
        if(startIndex>=s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i=startIndex;i<s.length();i++){
            if(isPalindrome(s.substring(startIndex,i+1))){
                path.add(s.substring(startIndex,i+1));
                f(s,i+1);
                path.remove(path.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s){
        for(int i = 0,j = s.length()-1; i < j; i++,j--){
            if(s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Partition().partition("aab"));
    }
}
