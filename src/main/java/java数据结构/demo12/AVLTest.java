package java数据结构.demo12;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;
import java.util.TreeMap;


public class AVLTest {
    public final int MAX = 65535;
    private Random random = new Random();

    @Test
    public void testPutAndItr() {
        AVLMap<Integer, String> map1 = new AVLMap<Integer, String>();
        TreeMap<Integer, String> map2 = new TreeMap<Integer, String>();
        for (int i = 0; i < MAX; i++) {
            int key = random.nextInt(MAX);
            String value = random.nextInt(MAX) + "";
            map1.put(key, value);
            map2.put(key, value);
        }
        Assert.assertTrue(map1.size() == map2.size());
        System.out.println(map2.size());
    }
}




