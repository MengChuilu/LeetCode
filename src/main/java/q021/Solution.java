package q021;

import base.ListNode;

// 第一次一次过，也没编译，这个不是中等吧？
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode next = root;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                next.next = l1;
                l1 = l1.next;
            } else {
                next.next = l2;
                l2 = l2.next;
            }
            next = next.next;
            next.next = null;
        }

        if (l1 == null) {
            next.next = l2;
        } else {
            next.next = l1;
        }

        return root.next;
    }
}