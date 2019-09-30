package java数据结构.demo12;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;


public class AVLMap<K, V> implements Iterator<AVLEntry<K, V>> {
    private int size;
    private AVLEntry<K, V> root;
    private Comparator<K> comp;
    private LinkedList<AVLEntry<K, V>> stack = new LinkedList<AVLEntry<K, V>>();

    private int compare(K a, K b) {
        if (comp != null) {
            return comp.compare(a, b);
        } else {
            Comparable<K> c = (Comparable<K>) a;
            return c.compareTo(b);
        }
    }

    public AVLMap(Comparator<K> comp) {
        super();
        this.comp = comp;
    }

    public AVLMap() {
        super();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    public V put(K key, V value) {
        if (root == null) {
            root = new AVLEntry<K, V>(key, value);
            stack.offer(root);
            size++;
        } else {
            AVLEntry<K, V> p = root;
            while (p != null) {
                stack.offer(p);
                int compareResult = compare(key, p.key);
                if (compareResult == 0) {
                    p.setValue(value);
                    break;
                } else if (compareResult < 0) {
                    if (p.left == null) {
                        p.left = new AVLEntry<K, V>(key, value);
                        size++;
                        stack.add(p.left);
                        break;
                    } else {
                        p = p.right;
                    }
                } else {
                    if (p.right == null) {
                        p.right = new AVLEntry<K, V>(key, value);
                        size++;
                        stack.add(p.right);
                        break;
                    } else {
                        p = p.right;
                    }
                }

            }
        }
        return value;
    }


//    public Iterator<AVLEntry<K, V>> iterator() {
//        return new AVLIterator<K, V>(root);
//    }

    public boolean hasNext() {
        return false;
    }

    public AVLEntry<K, V> next() {
        return null;
    }

    public void remove() {

    }
}
