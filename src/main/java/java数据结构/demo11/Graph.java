package java数据结构.demo11;

import java数据结构.demo2.Mystack;

/**
 * @Author: 许国亮
 * @Date: 2019/9/23 10:13 PM
 * @Version 1.0
 */
public class Graph {
    private Vertex[] vertex;
    private int currentSize;
    public int[][] adjMat;
    private Mystack stack = new Mystack();
    private int currentIndex;

    public Graph(int size) {
        vertex = new Vertex[size];
        adjMat = new int[size][size];
    }
//    public void addVertex()


}
