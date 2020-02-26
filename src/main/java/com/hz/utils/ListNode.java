package com.hz.utils;

public class ListNode {

    int val;

    ListNode next;

    public ListNode(int val) {
        this.val=val;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dumpy = new ListNode(-1);
        dumpy.next = head;
        ListNode pre = dumpy;
        ListNode current = pre.next;
        while(current != null) {
            if(current.next != null && current.val == current.next.val) {
                while(current.next != null && current.val == current.next.val) {
                    current = current.next;
                }
                pre.next = current.next;
                current = current.next;
            }else {
                pre = pre.next;
                current = current.next;
            }
        }
        return dumpy.next;
    }
}
