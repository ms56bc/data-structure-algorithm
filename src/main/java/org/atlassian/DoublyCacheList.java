/*
package org.atlassian;

public class DoublyCacheList {
    private CacheNode head, tail;

    static class CacheNode {
        CacheNode next;
        CacheNode prev;
        int value;

        public CacheNode(CacheNode next, CacheNode prev, int value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }
    }

    public DoublyCacheList() {
    }

    public void insert(int value) {
        var node = new CacheNode(null, null, value);
        if (head == null) {
            head = node;
        }
        if (tail != null) {
            tail.prev = node;
            node.next = tail;
        }
        tail = node;
    }

    public void remove(CacheNode node) {
        if(node ==null) return;
        if(node == tail){
            tail = node.next;
            node.next.prev = null;
        }
        else node.prev.next = node.next;
        if(node == head){
            head = node.prev;
            node.prev.next = null;
        }
        node.next.prev = node.prev;
    }
}
*/
