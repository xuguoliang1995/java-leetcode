package java数据结构.demo2;

/**
 * @Author: 许国亮
 * @Date: 2019/9/19 9:58 AM
 * @Version 1.0
 */
public class DoubleNode {
    DoubleNode pre = this;
    DoubleNode next = this;
    int data;

    public DoubleNode(int data) {
        this.data = data;
    }

    public void after(DoubleNode node) {
        DoubleNode nextNext = next;
        this.next = node;
        node.pre = this;
        node.next = nextNext;
        nextNext.pre = node;
    }

    //下一个节点
    public DoubleNode next() {
        return this.next;
    }

    //上一个节点
    public DoubleNode pre() {
        return this.pre;
    }

    //获取数据
    public int getData() {
        return this.data;
    }
}
