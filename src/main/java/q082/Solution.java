package q082;

import base.ListNode;

/**
 * @author mengchuilu
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return head;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        ListNode next = head;
        ListNode p = newHead;

        while (next != null && next.next != null) {
            if (next.val == next.next.val) {
                int t = next.val;
                while (next != null && next.val == t) {
                    next = next.next;
                }
                continue;
            }
            p.next = next;
            p = p.next;
            next = next.next;
        }

        p.next = next;
        return head;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode p1 = new ListNode(1);
        head.next = p1;

        Solution solution = new Solution();
        solution.deleteDuplicates(head);
    }
}
