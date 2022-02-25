package cn.wang3;

import cn.wang.CalculatorImp;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CiglibProxyFactory {
    /*目标对象*/
    private CalculatorImp calculatorImp;

    public CiglibProxyFactory(CalculatorImp calculatorImp) {
        this.calculatorImp = calculatorImp;
    }

    public Object getCiglibProxyObjct(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CalculatorImp.class);
        /*代理类型的代理方法 拦截方法*/
enhancer.setCallback(new MethodInterceptor() {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(method.getName()+"方法的参数"+objects);
        Object result = methodProxy.invoke(calculatorImp, objects);
        System.out.println(method.getName()+"方法的结果"+result);
        return result;
    }
});
Object obj  = enhancer.create();
        return  obj;
    }
}
