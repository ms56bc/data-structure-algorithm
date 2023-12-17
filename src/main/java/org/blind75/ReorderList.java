package org.blind75;

public class ReorderList {
    public static void main(String[] args) {
        var reorderList = new ReorderList();
        var head = new ReverseLinkedList.ListNode(1, new ReverseLinkedList.ListNode(2, new ReverseLinkedList.ListNode(3, new ReverseLinkedList.ListNode(4, new ReverseLinkedList.ListNode(5, new ReverseLinkedList.ListNode(6))))));
        extracted(head);
        reorderList.reorderList(head);
        System.out.println(" ");
        extracted(head);
    }

    private static void extracted(ReverseLinkedList.ListNode ans) {
        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }

    private void reorderList(ReverseLinkedList.ListNode head) {

        ReverseLinkedList.ListNode ftemp, ltemp;

        var mid = findMid(head);
        var last = reverse(mid);

        while (head != null && last != null) {
            ltemp = last.next;
            ftemp = head.next;

            last.next = ftemp;
            head.next = last;

            last = ltemp;
            head = ftemp;
        }
    }

    private ReverseLinkedList.ListNode findMid(ReverseLinkedList.ListNode node) {
        ReverseLinkedList.ListNode temp = node;
        while (temp.next != null && temp.next.next != null) {
            temp = temp.next.next;
            node = node.next;
        }
        return node;
    }

    private ReverseLinkedList.ListNode reverse(ReverseLinkedList.ListNode node) {
        ReverseLinkedList.ListNode temp;
        ReverseLinkedList.ListNode prev = null;
        while (node != null) {
            temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        return prev;
    }
}
