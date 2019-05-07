package q025;

import base.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode pre = new ListNode(0);
        pre.next = head;
        head = pre;
        ListNode tail = head;
        while (tail != null) {
            ListNode p = head.next;
            head.next = null;
            boolean end = false;
            for (int i = 0;i < k;i ++) {
                if (p == null) {
                    end = true;
                    break;
                }
                stack.push(p);
                p = p.next;
                stack.peek().next = null;
            }
            tail = p;
            if (!end) {
                while (!stack.isEmpty()) {
                    head.next = stack.pop();
                    head = head.next;
                }
            } else {
                while (!stack.isEmpty()) {
                    head.next = stack.removeLast();
                    head = head.next;
                }
            }

            head.next = tail;
        }

        return pre.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        Solution solution = new Solution();
        solution.reverseKGroup(listNode1, 3);
    }
}