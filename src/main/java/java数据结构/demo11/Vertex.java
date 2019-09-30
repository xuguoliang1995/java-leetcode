package java数据结构.demo11;

/**
 * @Author: 许国亮
 * @Date: 2019/9/23 10:24 PM
 * @Version 1.0
 */
public class Vertex {
    private String value;
    public boolean vistited;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Vertex(String value) {
        super();
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

