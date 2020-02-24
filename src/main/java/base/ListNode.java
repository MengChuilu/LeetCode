package base;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode buildLinkedList(int... param) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        for (int i = 0;i < param.length;i ++) {
            p.next = new ListNode(param[i]);
            p = p.next;
        }

        return head.next;
    }
}