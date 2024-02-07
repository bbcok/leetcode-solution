package org.example.LinkedList;

import org.example.struct.ListNode;
import org.example.struct.TreeNode;

public class ReverseList {

    ListNode reverse(ListNode node){
        if(node==null||node.next==null){
            return node;
        }
        ListNode last=reverse(node.next);
        node.next.next=node;
        node.next=null;
        return last;
    }

    ListNode suc=null;
    ListNode reverseN(ListNode node,int n){
        if (n==1){
            suc=node.next;
            return node;
        }
        ListNode last=reverseN(node.next,n-1);
        node.next.next=node;
        node.next=suc;
        return last;
    }

    ListNode reverseKGroup(ListNode node,int k){
        ListNode p=node;
        for (int i=0;i<k;i++){
            if (p==null) return node;
            p=p.next;
        }
        ListNode last=reverseN(node,k);
        node.next=reverseKGroup(p,k);
        return last;
    }

}
