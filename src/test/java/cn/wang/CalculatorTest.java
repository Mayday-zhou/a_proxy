package cn.wang;

import cn.wang2.JdkProxyFactory;
import cn.wang3.CiglibProxyFactory;
import org.junit.Test;

public class CalculatorTest {

    /*静态代理*/
    @Test
    public void test2(){
        Calculator calculator = new CalculatorStaticProxy(new CalculatorImp());
        int result = calculator.add(5,7);
         result = calculator.sub(5,7);
         result = calculator.mul(5,7);
         result = calculator.div(5,7);
    }

    /**代理模式
     * 动态代理
     * 很方便去扩展
     * */
    @Test
    public void test3(){
        JdkProxyFactory factory = new JdkProxyFactory(new CalculatorImp());
        Calculator ProxyObject = factory.getJdkProxyObject();
       int result =   ProxyObject.add(2,7);
        System.out.println(result);
        ProxyObject.sub(5,7);
         ProxyObject.mul(5,7);
         ProxyObject.div(5,7);
    }

/*框架的动态代理*/
    @Test
    public void test4(){
        CiglibProxyFactory factory = new CiglibProxyFactory(new CalculatorImp());
        Calculator ProxyObject = (Calculator) factory.getCiglibProxyObjct();
        ProxyObject.add(2,7);
        ProxyObject.sub(5,7);
        ProxyObject.mul(5,7);
        ProxyObject.div(5,7);
    }
}
