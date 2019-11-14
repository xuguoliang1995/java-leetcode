package java数据结构.JVMDemo;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: 许国亮
 * @Date: 2019/10/30 3:56 PM
 * @Version 1.0
 */
public class Demo7 {
    private volatile Enhancer enhancer = null;
    public void doSomething(){
        if(enhancer == null){
            this.enhancer = new Enhancer();
            enhancer.setUseCache(false);
            enhancer.setSuperclass(Car.class);
            enhancer.setCallback(new MethodInterceptor() {
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    if(method.getClass().equals("run")){
                        System.out.println("启动汽车之前进行自检");
                        return methodProxy.invokeSuper(o,objects );
                    }else{
                        return methodProxy.invokeSuper(o,objects );
                    }
                }
            });
        }

    }
    public static class Car {
        public void run() {
            System.out.println("汽车启动，开始行驶....");
        }
    }
}
