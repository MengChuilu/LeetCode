package q023;

import base.ListNode;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return map(lists, 0, lists.length-1);
    }

    public ListNode map(ListNode[] lists, int start, int end) {
        if (end == start + 1) {
            return reduce(lists[start], lists[end]);
        }

        if (start == end) {
            return lists[end];
        }

        if (start >= lists.length && end < lists.length) {
            return lists[end];
        }

        int mid = (start + end) / 2;
        return reduce(map(lists, start, mid), map(lists, mid+1, end));
    }

    public ListNode reduce(ListNode listNode1, ListNode listNode2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (listNode1 != null && listNode2 != null) {
            if (listNode1.val <= listNode2.val) {
                p.next = listNode1;
                listNode1 = listNode1.next;
            } else {
                p.next = listNode2;
                listNode2 = listNode2.next;
            }
            p = p.next;
        }

        if (listNode1 == null) {
            p.next = listNode2;
        } else {
            p.next = listNode1;
        }
        return head.next;
    }
}