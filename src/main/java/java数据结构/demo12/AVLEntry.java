package java数据结构.demo12;

import java.util.Map;

//Ctrl+D，复制行
public class AVLEntry<K, V> implements Map.Entry<K, V> {
    public K key;
    public V value;
    public AVLEntry<K, V> left;
    public AVLEntry<K, V> right;

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public V setValue(V value) {
        this.value = value;
        return value;
    }

    public AVLEntry(K key, V value) {
        super();
        this.key = key;
        this.value = value;
    }

    public AVLEntry(K key) {
        super();
        this.key = key;
    }

    public AVLEntry(K key, V value, AVLEntry<K, V> left, AVLEntry<K, V> right) {
        super();
        this.key = key;
        this.value = value;
        this.left = left;
        this.value = value;
    }


    @Override
    public String toString() {
        return "AVLEntry{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
