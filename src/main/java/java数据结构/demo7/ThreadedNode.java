package java数据结构.demo7;

/**
 * @Author: 许国亮
 * @Date: 2019/9/20 11:20 AM
 * @Version 1.0
 */
public class ThreadedNode {
    int value;
    ThreadedNode leftNode;
    ThreadedNode rightNode;
    int leftType;
    int rightType;

    public ThreadedNode(int value) {
        this.value = value;
    }

    public void setLeftNode(ThreadedNode leftNode) {
        this.leftNode = leftNode;

    }

    public void setRightNode(ThreadedNode rigthNode) {
        this.rightNode = rigthNode;
    }

    public void frontShow() {
        System.out.println(value);
        if (leftNode != null) {
            leftNode.frontShow();
        }
        if (rightNode != null) {
            rightNode.frontShow();
        }
    }

    public void midShow() {
        if (leftNode != null) {
            leftNode.midShow();
        }
        System.out.println(value);
        if (rightNode != null) {
            rightNode.midShow();
        }
    }

    public void afterShow() {
        if (leftNode != null) {
            leftNode.afterShow();
        }
        if (rightNode != null) {
            rightNode.afterShow();
        }
        System.out.println(value);
    }

    public void delete(int i) {
        ThreadedNode parent = this;
        if (parent.leftNode != null && parent.leftNode.value == i) {
            parent.leftNode = null;
            return;
        }
        if (parent.rightNode != null && parent.rightNode.value == i) {
            parent.rightNode = null;
            return;
        }
        parent = leftNode;
        if (parent != null) {
            parent.delete(i);
        }
        parent = rightNode;
        if (parent != null) {
            parent.delete(i);
        }
    }

    //前序查找
    public ThreadedNode frontSearch(int i) {
        ThreadedNode target=null;
        //对比当前节点的值
        if(this.value==i) {
            return this;
            //当前节点的值不是要查找的节点
        }else {
            //查找左儿子
            if(leftNode!=null) {
                //有可能可以查到，也可以查不到，查不到的话，target还是一个null
                target = leftNode.frontSearch(i);
            }
            //如果不为空，说明在左儿子中已经找到
            if(target!=null) {
                return target;
            }
            //查找右儿子
            if(rightNode!=null) {
                target=rightNode.frontSearch(i);
            }
        }
        return target;
    }
}
