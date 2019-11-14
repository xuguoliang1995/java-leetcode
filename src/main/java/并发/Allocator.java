package 并发;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 许国亮
 * @Date: 2019/11/7 12:14 PM
 * @Version 1.0
 */
public class Allocator {
    private List<Object> als = new ArrayList<>();
    //一次性申请所有资源
    synchronized boolean apply(Object from, Object to){
        if (als.contains(from) || als.contains(to)){
            return false;
        } else {
            als.add(from);
            als.add(from);
        }
        return true;
    }
    synchronized void free(Object from, Object to){
        als.remove(from);
        als.remove(to);
    }
}
