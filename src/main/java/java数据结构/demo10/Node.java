package java数据结构.demo10;

/**
 * @Author: 许国亮
 * @Date: 2019/9/22 8:38 PM
 * @Version 1.0
 */
public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (node.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
        if (leftHeight() - rightHeight() >= 2) {
            if (left != null && left.leftHeight() < left.rightHeight()) {
                left.leftRotate();
            } else {
                rightRotate();
            }

        }
        if (leftHeight() - rightHeight() <= -2) {
            if (right != null && right.rightHeight() < right.leftHeight()) {
                right.rightRotate();
                leftRotate();
            }
            leftRotate();
        }
    }

    private void rightRotate() {
        Node newRight = new Node(value);
        newRight.right = right;
        newRight.left = left.right;
        value = left.value;
        left = left.left;
        right = newRight;
    }

    private void leftRotate() {
        Node newLeft = new Node(value);
        newLeft.left = left;
        newLeft.right = right.left;
        value = right.value;
        right = right.right;
        left = newLeft;
    }

    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ?
                0 : right.height()) + 1;
    }

    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    public void midShow(Node node) {
        if (node == null) {
            return;
        }
        midShow(node.left);
        System.out.println(node.value);
        midShow(node.right);
    }

    public Node search(int value) {
        if (this.value == value) {
            return this;
        } else if (value < this.value) {
            if (left == null) {
                return null;
            }
            return left.search(value);
        } else {
            if (right == null) {
                return null;
            }
            return right.search(value);
        }
    }

    public Node searchParent(int value) {
        if (this.left != null && this.left.value == value || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (this.value > value && this.left != null) {
                return this.left.searchParent(value);
            } else if (this.value < value && this.right != null) {
                return this.right.searchParent(value);
            }
            return null;
        }
//        
    }
}


