package com.hz.utils;

public class Node {
    int value;
    Node next;
    public Node(int value){
        this.value=value;
    }



    public Node quchong(Node head){
        if(head==null||head.next==null){
                  return head;
        }
        Node dump=new Node(-1);
        dump.next=head;
        Node pre=dump;
        Node curr=pre.next;
        while(curr!=null){
            if(curr.next!=null&&curr.value==curr.next.value){
                while(curr.next!=null&&curr.value==curr.next.value){
                    curr=curr.next;
                }
                pre.next=curr.next;
                curr=curr.next;
            }else {
                pre=pre.next;
                curr=curr.next;
            }
        }
           return dump.next;
    }
}
