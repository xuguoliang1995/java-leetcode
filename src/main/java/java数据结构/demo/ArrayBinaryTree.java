package java数据结构.demo;

/**
 * @Author: 许国亮
 * @Date: 2019/9/20 10:59 AM
 * @Version 1.0
 */
public class ArrayBinaryTree {
    int[] data;

    public ArrayBinaryTree(int[] data) {
        this.data = data;
    }

    public void frontShow() {
        frontShow(0);
    }

    public void frontShow(int index) {
        if (data == null || data.length == 0) return;
        System.out.println(data[index]);
        if (2 * index + 1 < data.length) {
            frontShow(2 * index + 1);
        }
        if (2 * index + 2 < data.length) {
            frontShow(2 * index + 2);
        }

    }


}
