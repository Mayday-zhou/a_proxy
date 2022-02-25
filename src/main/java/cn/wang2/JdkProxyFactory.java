package cn.wang2;


import cn.wang.Calculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*基于jdk自带的动态代理= 需要有接口的类实现*/
public class JdkProxyFactory {
    private Calculator calculator;

    public JdkProxyFactory(Calculator calculator) {
        this.calculator = calculator;
    }

    /*工厂方法*/
    public Calculator getJdkProxyObject(){
        /*类加载、接口、调用方法*/
        ClassLoader loader = calculator.getClass().getClassLoader();
        Class<?>[] interfaces = calculator.getClass().getInterfaces();
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws InvocationTargetException, IllegalAccessException {
                System.out.println(method.getName()+"方法的参数："+objects);
                Object result=method.invoke(calculator,objects);  /*调用了目标方法--反射调用所以方法都可以用*/
                System.out.println(method.getName()+"方法的结果:"+result);
                return result;
            }
        };
        Calculator obj = (Calculator) Proxy.newProxyInstance(loader, interfaces, invocationHandler);
        return obj;
    }


}
