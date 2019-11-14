package java数据结构.JVMDemo;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Demo4 {
    public static void main(String[] args) {
        long counter = 0l;
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(Car.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    if (method.getName().equals("run")) {
                        System.out.println("启动汽车之前，先进行自动的安全检查.....");
                        return methodProxy.invokeSuper(o, objects);
                    } else {
                        return methodProxy.invokeSuper(o, objects);
                    }
                }
            });
            Car car = (Car) enhancer.create();
            car.run();
        }
    }

    public static class Car {
        public void run() {
            System.out.println("汽车启动，开始行驶....");
        }
    }

    static class SafeCar extends Car {
        @Override
        public void run() {
            System.out.println("汽车启动,开始行驶");
            super.run();
        }
    }
}
