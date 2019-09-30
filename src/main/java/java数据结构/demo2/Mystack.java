package java数据结构.demo2;

/**
 * @Author: 许国亮
 * @Date: 2019/9/18 9:41 PM
 * @Version 1.0
 */
public class Mystack {
    int[] elements;

    public Mystack() {
        elements = new int[0];
    }

    public void push(int element) {
        int[] newArr = new int[elements.length + 1];
        for (int i = 0; i < elements.length; i++) {
            newArr[i] = elements[i];
        }
        newArr[elements.length] = element;
        elements = newArr;
    }

    public int pop() {
        if (elements.length == 0) {
            throw new RuntimeException("stack is empty");
        }
        int element = elements[elements.length - 1];
        int[] newArr = new int[elements.length - 1];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = elements[i];

        }
        elements = newArr;
        return element;
    }

    public int peek() {
        if (elements.length == 0) {
            throw new RuntimeException("Stack is empty");
        }
        return elements[elements.length - 1];
    }

    public boolean isEmpty() {
        return elements.length == 0;
    }

}
