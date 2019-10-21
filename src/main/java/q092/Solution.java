package q092;

import base.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author mengchuilu
 */
public class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode p = head;
        int i = 1;

        Deque<Integer> stack = new ArrayDeque<>();

        while (p != null) {
            if (i >= m && i <= n) {
                stack.push(p.val);
            }

            p = p.next;
            i ++;
        }

        p = head;
        i = 1;
        while (p != null) {
            if (i >= m && i <= n) {
                p.val = stack.poll();
            }

            p = p.next;
            i ++;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        Solution solution = new Solution();
        solution.reverseBetween(listNode1, 1,2);
    }
}