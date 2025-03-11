package org.example.recurrence;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    List<String> ans = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    public List<String> restoreIpAddresses(String s){
        return null;
    }
    boolean isValid(String s){
        return false;
    }
    public void f(String s, int startIndex){
        if(startIndex>=s.length()){
            ans.add(new String(path));
            return;
        }
        for(int i=startIndex;i<s.length();i++){
            String sub = s.substring(startIndex,i+1);
            if(isValid(sub)){
                path.append(sub);
                path.append(".");
                f(s,i+1);
                path.delete(path.length()-sub.length()-1,path.length());
            }
        }
    }
}
