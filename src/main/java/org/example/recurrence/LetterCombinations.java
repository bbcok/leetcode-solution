package org.example.recurrence;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    static List<String> ans = new ArrayList<>();
    public static List<String> letterCombinations(String digits) {
        String [] letterMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        f(digits, 0, letterMap, new StringBuilder());
        return ans;
    }
    public static void f(String digits, int i, String[] letterMap, StringBuilder combine){
        if(i == digits.length()){
            ans.add(combine.toString());
            return;
        }
        int index = digits.charAt(i)-'0';
        for(int j=0;j<letterMap[index].length();j++){
            combine.append(letterMap[index].charAt(j));
            f(digits, i+1, letterMap, combine);
            combine.deleteCharAt(combine.length()-1);
        }
    }
    public static void main(String[] args){
        System.out.println(letterCombinations("233"));
    }
}
