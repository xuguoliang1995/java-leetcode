package java数据结构.demo8;

/**
 * @Author: 许国亮
 * @Date: 2019/9/20 3:28 PM
 * @Version 1.0
 */
public class Node implements Comparable<Node> {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }


    public int compareTo(Node o) {
        return -(this.value - o.value);
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
