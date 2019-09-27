package q061;

import base.ListNode;

/**
 * @author mengchuilu
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        ListNode p = head;
        int length = 0;
        while (p != null) {
            p = p.next;
            length ++;
        }
        k = k % length;
        p = head;
        for (int i = 0; i < k; i++) {
            p = p.next == null ? head : p.next;
        }

        ListNode q = head;
        while (p.next != null) {
            p = p.next;
            q = q.next == null ? head : q.next;;
        }

        ListNode newHead = q.next == null ? head : q.next;
        q.next = null;
        if (newHead == head) {
            return head;
        }

        p = newHead;
        while (p.next != null) {
            p = p.next;
        }

        p.next = head;

        return newHead;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);


        l1.next = l2;
        l2.next = l3;

        Solution solution = new Solution();
        solution.rotateRight(l1, 2000000000);
        System.out.println("");
    }
}