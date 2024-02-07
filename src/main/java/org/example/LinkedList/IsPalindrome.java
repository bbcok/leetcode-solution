package org.example.LinkedList;

import org.example.struct.ListNode;

public class IsPalindrome {
    boolean isPalindrome(ListNode node){
        return a.equals(b);
    }
    public String a="";
    public String b="";
    void treaverse(ListNode node){
        if (node==null) {
            return;
        }
        a=a+node.val;
        treaverse(node.next);
        b=b+node.val;
    }

    public static void main(String[] args) {
        int [] a={1,2};
        ListNode node=new ListNode(0);
        ListNode root=node;

        for (int i:a){
            ListNode l=new ListNode(i);
            node.next=l;
            node=node.next;
        }
        IsPalindrome isPalindrome=new IsPalindrome();
        isPalindrome.treaverse(root.next);
        System.out.println(isPalindrome.isPalindrome(root));
        System.out.println(isPalindrome.a);
        System.out.println(isPalindrome.b);

    }
}
