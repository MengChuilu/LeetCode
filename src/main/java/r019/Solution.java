package r019;

import base.ListNode;

import java.util.*;

public class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ListNode p = head;
        int[] result = new int[1000];

        Deque<Integer> indexStack = new ArrayDeque<>();
        Deque<Integer> stack = new ArrayDeque<>();

        int index = 0;
        while (p != null) {
            while (!stack.isEmpty() && p.val > stack.peekFirst()) {
                int nowIndex = indexStack.removeFirst();
                stack.removeFirst();
                result[nowIndex] = p.val;
            }
            stack.addFirst(p.val);
            indexStack.addFirst(index);
            p = p.next;

            index ++;
        }

        while (!indexStack.isEmpty()) {
            int nowIndex = indexStack.removeLast();
            result[nowIndex] = 0;
        }

        return Arrays.copyOf(result, index);
    }
}