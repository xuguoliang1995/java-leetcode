package java数据结构.demo2;

/**
 * @Author: 许国亮
 * @Date: 2019/9/18 9:32 PM
 * @Version 1.0
 */
public class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }

    public Node append(Node node) {
        Node currentNode = this;
        while (true) {
            Node nextNode = currentNode.next;
            if (nextNode == null) {
                break;
            }
            currentNode = nextNode;
        }
        currentNode.next = node;
        return this;
    }

    public void after(Node node) {
        Node nextNext = next;
        this.next = node;
        node.next = nextNext;
    }

    public void show() {
        Node currentNode = this;
        while (true) {
            System.out.println(currentNode.data + " ");
            currentNode = currentNode.next;
            if (currentNode == null) {
                break;
            }
        }
        System.out.println();
    }

    public void removeNext() {
        Node newNext = next.next;
        this.next = newNext;
    }

    public Node next() {
        return this.next;
    }

    public int getData() {
        return this.data;
    }

    public boolean isLast() {
        return next == null;
    }

}
