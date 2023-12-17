package org.blind75;

public class ReverseLinkedList {
    public static void main(String[] args) {
        var reverseLinkedList = new ReverseLinkedList();
        var head = reverseLinkedList.reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
    // 1-2-3-4-n
    //
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
