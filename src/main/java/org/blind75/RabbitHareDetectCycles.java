package org.blind75;

import java.util.Objects;

public class RabbitHareDetectCycles {
    public static void main(String[] args) {
        var reverseLinkedList = new RabbitHareDetectCycles();
        var hasCycles = reverseLinkedList.detectCycles(new ReverseLinkedList.ListNode(1, new ReverseLinkedList.ListNode(2, new ReverseLinkedList.ListNode(3, new ReverseLinkedList.ListNode(4, new ReverseLinkedList.ListNode(5))))));
        System.out.println(hasCycles);

        hasCycles = reverseLinkedList.detectCycles(reverseLinkedList.createList());
        System.out.println(hasCycles);
    }
    private boolean detectCycles(ReverseLinkedList.ListNode head){
        ReverseLinkedList.ListNode fast = head;
        ReverseLinkedList.ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(Objects.equals(slow, fast)) return true;
        }
        return false;
    }
    private ReverseLinkedList.ListNode createList(){
        var node5 = new ReverseLinkedList.ListNode(5);
        var node4 = new ReverseLinkedList.ListNode(4, node5);
        var node3 = new ReverseLinkedList.ListNode(3, node4);
        var node2 = new ReverseLinkedList.ListNode(2, node3);
        var node1 = new ReverseLinkedList.ListNode(1, node2);
        node5.next = node2;
        return node1;
    }
}
