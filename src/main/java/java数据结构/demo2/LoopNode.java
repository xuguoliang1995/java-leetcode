package java数据结构.demo2;

/**
 * @Author: 许国亮
 * @Date: 2019/9/19 9:46 AM
 * @Version 1.0
 */
public class LoopNode {
    int data;
    LoopNode next = this;

    public LoopNode(int data) {
        this.data = data;
    }

    public void after(LoopNode node) {
        LoopNode nextNext = next;
        this.next = node;
        node.next = nextNext;
    }

    public void removeNext() {
        LoopNode newNext = next.next;
        this.next = newNext;
    }

    public LoopNode next() {
        return this.next;
    }

    public int getData() {
        return this.data;
    }
}
