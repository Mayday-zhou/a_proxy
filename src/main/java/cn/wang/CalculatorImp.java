package cn.wang;

public class CalculatorImp implements Calculator{
    @Override
    public int add(int a, int b) {
        int c = a+b;
        return c;
    }

    @Override
    public int sub(int a, int b) {
        int c = a-b;
        return c;
    }

    @Override
    public int mul(int a, int b) {
        int c = a*b;
        return c;
    }

    @Override
    public int div(int a, int b) {
        int c = a/b;
        return c;
    }
}
