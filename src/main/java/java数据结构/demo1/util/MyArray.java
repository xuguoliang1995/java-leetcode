package java数据结构.demo1.util;

/**
 * @Author: 许国亮
 * @Date: 2019/9/18 8:57 PM
 * @Version 1.0
 */
public class MyArray {
    private int[] elements;

    public MyArray() {
        elements = new int[0];
    }

    public int size() {
        return elements.length;
    }

    public void add(int element) {
        int[] newArr = new int[elements.length + 1];
        for (int i = 0; i < elements.length; i++) {
            newArr[i] = elements[i];
        }
        newArr[elements.length] = element;
        elements = newArr;
    }

    public int get(int index) {
        if (index < 0 || index > elements.length - 1) {
            throw new RuntimeException("下标越界");
        }
        return elements[index];
    }

    public void insert(int index, int element) {
        int[] newArr = new int[elements.length + 1];
        for (int i = 0; i < elements.length; i++) {
            if (i < index) {
                newArr[i] = elements[i];
            } else {
                newArr[i + 1] = elements[i];
            }
        }
        newArr[index] = element;
        elements = newArr;
    }

    public void set(int index, int element) {
        if (index < 0 || index > elements.length - 1) {
            throw new RuntimeException("下标越界");
        }
        elements[index] = element;
    }

    public int search(int target) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == target) {
                return i;
            }

        }
        return -1;
    }

    public int binarySearch(int target) {
        int begin = 0;
        int end = elements.length - 1;
        int mid = (begin + end) / 2;
        while (true) {
            if (begin > end) {
                return -1;
            } else {
                if (elements[mid] == target) {
                    return mid;
                } else {
                    if (elements[mid] > target) {
                        end = mid - 1;
                    } else {
                        begin = mid + 1;
                    }
                    mid = (begin + end) / 2;
                }
            }

        }
    }
}
