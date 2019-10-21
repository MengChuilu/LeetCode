package q086;

import base.ListNode;

/**
 * @author mengchuilu
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {

        ListNode phead = new ListNode(-1);
        ListNode p = phead;

        ListNode qhead = new ListNode(-1);
        ListNode q = qhead;

        while (head != null) {
            if (head.val >= x) {
                q.next = head;
                head = head.next;
                q = q.next;
                q.next = null;
            } else {
                p.next = head;
                head = head.next;
                p = p.next;
                p.next = null;
            }
        }

        p.next = qhead.next;
        return phead.next;
    }
}