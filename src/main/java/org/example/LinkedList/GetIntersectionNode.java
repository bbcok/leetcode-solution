package org.example.LinkedList;

import org.example.struct.ListNode;

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa=headA;
        ListNode pb=headB;
        while(pa!=pb){
            if (pb.next!=null){
                pb=pb.next;
            }
            else pb=headA;
            if (pa.next!=null){
                pa=pa.next;
            }
            else pa=headB;

        }
        return pa;
    }
}
