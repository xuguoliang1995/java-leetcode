package java数据结构.demo2.test;

import java数据结构.demo2.Node;

/**
 * @Author: 许国亮
 * @Date: 2019/9/18 9:32 PM
 * @Version 1.0
 */
public class TestNode {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.append(n2).append(n3).append(new Node(4));
        n1.show();
        System.out.println(n1.next().next().getData());


    }

}
