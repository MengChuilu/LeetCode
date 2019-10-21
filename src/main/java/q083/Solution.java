package q083;

import base.ListNode;

/**
 * @author mengchuilu
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode p = head;
        ListNode next = head.next;

        while (next != null) {
            if (p.val == next.val) {
                next = next.next;
                continue;
            }

            p.next = next;
            p = p.next;
            next = next.next;
        }
        p.next = next;

        return head;
    }
}