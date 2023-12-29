/*
package org.example.cache;

import java.util.*;

public class LRUCache<K, V> implements Cache<K, V> {
    static class KeyValue<K, V> {
        K key;
        V value;

        public KeyValue(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<K, V> storage;
    long maxElements;
    Queue<KeyValue<K, V>> orderElements;

    public LRUCache(long maxElements) {
        this.storage = new HashMap<>();
        this.maxElements = maxElements;
        this.orderElements = new LinkedList<>();
    }

    @Override
    public void put(K key, V value) {
        V v = storage.get(key);
        if(v ==null){

         }

        if (orderElements.size() > maxElements) {
            KeyValue<K, V> kv = orderElements.poll();
            storage.remove(kv.key);
        }

    }

    @Override
    public Optional<V> get(K key) {
        V value = storage.get(key);
        if(value == null)
            return Optional.empty();
        orderElements.remove(value);
        orderElements.offer(value);
        storage.put(key, value);
        return Optional.of(value);
    }

    @Override
    public long size() {
        return orderElements.size();
    }
}
*/
