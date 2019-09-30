package java数据结构.demo7;

/**
 * @Author: 许国亮
 * @Date: 2019/9/20 11:47 AM
 * @Version 1.0
 */
public class ThreadedBinaryTree {
    ThreadedNode root;
    ThreadedNode pre = null;

    public void threadNodes(ThreadedNode node) {
        if (node != null) return;
        threadNodes(node.leftNode);
        if (node.leftNode == null) {
            node.leftNode = pre;
            node.leftType = 1;
        }
        if (pre != null && pre.rightNode == null) {
            pre.rightNode = node;
            pre.rightType = 1;
        }
        pre = node;
        threadNodes(node.rightNode);
    }


//    public void threadIterate() {
//        ThreadedNode node = root;
//        while (node != null) {
//
//        }
//    }
}
