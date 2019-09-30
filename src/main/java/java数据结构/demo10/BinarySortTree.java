package java数据结构.demo10;

/**
 * @Author: 许国亮
 * @Date: 2019/9/22 9:32 PM
 * @Version 1.0
 */
public class BinarySortTree {
    Node root;

    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void midShow() {
        if (root != null) {
            root.midShow(root);
        }
    }

    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    public void delete(int value) {
        if (root == null) {
            return;
        } else {
            Node target = search(value);
            if (target == null) {
                return;
            }
            Node parent = searchParent(value);
            if (target.left == null && target.right == null) {
                if (parent.left.value == value) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else if (target.left != null && target.right != null) {
                int min = deleteMin(target.right);
                target.value = min;
            } else {
                if (target.left != null) {
                    if (parent.left.value == value) {
                        parent.left = target.left;
                    } else {
                        parent.right = target.left;
                    }
                } else {
                    if (parent.left.value == value) {
                        parent.left = target.right;
                    } else {
                        parent.right = target.right;
                    }
                }
            }

        }
    }

    private int deleteMin(Node node) {
        Node target = node;
        while (target.left != null) {
            target = target.left;
        }
        delete(target.value);
        return target.value;
    }

    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }


}
