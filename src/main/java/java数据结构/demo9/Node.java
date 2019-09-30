package java数据结构.demo9;

/**
 * @Author: 许国亮
 * @Date: 2019/9/20 4:11 PM
 * @Version 1.0
 */
public class Node implements Comparable<Node> {
    Byte data;
    int weight;
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }


    public int compareTo(Node o) {
        return -(this.weight - o.weight);
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }
}
