package org.example.cache;

import java.util.Optional;

public class DoubleLinkedList<E> {
    static class Node<E>{
        Node next;
        Node prev;
        E value;

        public Node(Node next, Node prev, E value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }
    }
    public Node<E> add(E element){
        return null;
    }
    public Node<E> head(){
        return null;
    };

    public E remove(Node<E> elem){
        return null;
    };
    public int size(){
        return 0;
    }
}
